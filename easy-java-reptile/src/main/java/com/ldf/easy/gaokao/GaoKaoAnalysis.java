package com.ldf.easy.gaokao;

import com.ldf.easy.ReptileApp;
import com.ldf.easy.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lidefu
 * @date 2020年07月24日14:42
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReptileApp.class)
public class GaoKaoAnalysis {

    @Autowired
    private RestTemplate restTemplate;

    private List<GaoKaoAnalysisResult> gaoKaoAnalysisResult = new ArrayList<>(3000);
    private List<GaoKaoAnalysisResult> gaoKaoAnalysisError = new ArrayList<>(3000);

    @Test
    public void outPutExcel() throws IOException {
        filter();
        System.out.println("outPutExcel begin");
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        sheetHeader(sheet);
        int index = 1;
        for (GaoKaoAnalysisResult result : this.gaoKaoAnalysisResult) {
            Row row = sheet.createRow(index++);
            dataRow(row, result);
        }
        FileOutputStream out = new FileOutputStream("D:\\高考报考分数分析.xls");
        workbook.write(out);
        out.close();
        System.out.println("outPutExcel begin");
    }

    @Test
    public void filter(){
        scoresOverYears();
        System.out.println("filter begin");
        //位次
        int section = 55428;
        gaoKaoAnalysisResult = gaoKaoAnalysisResult.stream()
                .filter(r -> r.filter(section))
                .collect(Collectors.toList());
        System.out.println("filter end");
    }

    @Test
    public void loadAllSchool(){
        System.out.println("loadAllSchool begin");
        int totalPage = 148, pageSize = 20;
        for(int i=1; i<=totalPage; i++){
            String url = "https://api.eol.cn/gkcx/api/?access_token=&admissions=&central=&department=&dual_class=&f211=&f985=&is_dual_class=&keyword=&page=" + i + "&request_type=1&school_type=&signsafe=&size=" +pageSize+ "&sort=view_total&type=&uri=apigkcx/api/school/hotlists";
            Map res = restTemplate.getForObject(url, Map.class);
            Object data = res.get("data");
            Map dataMap = JsonUtil.parse(data, Map.class);
            Object item = dataMap.get("item");
            List<GaoKaoAnalysisResult> gaoKaoAnalysisResults = JsonUtil.parseArray(item, GaoKaoAnalysisResult.class);
            gaoKaoAnalysisResult.addAll(gaoKaoAnalysisResults);
        }
       System.out.println("loadAllSchool end");
    }

    @Test
    public void scoresOverYears(){
        loadAllSchool();
        System.out.println(" scoresOverYears begin");
        int i=0;
        for(GaoKaoAnalysisResult s : gaoKaoAnalysisResult){
            int schoolId = s.schoolId();
            String url = "https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/" +schoolId+ "/13/2/1.json";
            try {
                log.info("----------------------------------------" + i++);
                Map res = restTemplate.getForObject(url, Map.class);
                Object data = res.get("data");
                Map dataMap = JsonUtil.parse(data, Map.class);
                Object item = dataMap.get("item");
                List<ScoresOverYears> scoresOverYears = JsonUtil.parseArray(item, ScoresOverYears.class);
                s.setScoresOverYears(scoresOverYears);
            }catch (Exception e){
                gaoKaoAnalysisError.add(s);
                log.error(url);
            }
        }
        System.out.println(" scoresOverYears end");
    }

    @Test
    public void test(){
        String url = "https://static-data.eol.cn/www/2.0/schoolprovinceindex/detial/769/13/2/1.json";
        Object res = restTemplate.getForObject(url, Object.class);
        System.out.println(1);
    }

    private void sheetHeader(Sheet sheet){
        //学校基本信息
        Row row = sheet.createRow(0);
        Cell cell_name = row.createCell(0);
        cell_name.setCellValue("名称");
        Cell cell_belong = row.createCell(1);
        cell_belong.setCellValue("省");
        Cell cell_city_name = row.createCell(2);
        cell_city_name.setCellValue("市");
        Cell cell_level_name = row.createCell(3);
        cell_level_name.setCellValue("市");
        Cell cell_nature_name = row.createCell(4);
        cell_nature_name.setCellValue("市");
        //历年成绩
        //2019
        Cell cell_19_min_section = row.createCell(5);
        cell_19_min_section.setCellValue("2019最低位次");
        Cell cell_19_min = row.createCell(6);
        cell_19_min.setCellValue("2019最低分");
        //2018
        Cell cell_18_min_section = row.createCell(7);
        cell_18_min_section.setCellValue("2018最低位次");
        Cell cell_18_min = row.createCell(8);
        cell_18_min.setCellValue("2018最低分");
        //2017
        Cell cell_17_min_section = row.createCell(9);
        cell_17_min_section.setCellValue("2017最低位次");
        Cell cell_17_min = row.createCell(10);
        cell_17_min.setCellValue("2017最低分");
        //2016
        Cell cell_16_min_section = row.createCell(11);
        cell_16_min_section.setCellValue("2016最低位次");
        Cell cell_16_min = row.createCell(12);
        cell_16_min.setCellValue("2016最低分");
        //2015
        Cell cell_15_min_section = row.createCell(13);
        cell_15_min_section.setCellValue("2015最低位次");
        Cell cell_15_min = row.createCell(14);
        cell_15_min.setCellValue("2015最低分");
    }

    private void dataRow(Row row, GaoKaoAnalysisResult result){
        //学校基本信息
        Cell cell_name = row.createCell(0);
        cell_name.setCellValue(result.getName());
        Cell cell_belong = row.createCell(1);
        cell_belong.setCellValue(result.getBelong());
        Cell cell_city_name = row.createCell(2);
        cell_city_name.setCellValue(result.getCity_name());
        Cell cell_level_name = row.createCell(3);
        cell_level_name.setCellValue(result.getLevel_name());
        Cell cell_nature_name = row.createCell(4);
        cell_nature_name.setCellValue(result.getNature_name());
        //历年成绩
        //2019
        ScoresOverYears years19 = result.findScoreYear("2019");
        Cell cell_19_min_section = row.createCell(5);
        cell_19_min_section.setCellValue(years19 == null ? 0.0 : years19.getMin_section());
        Cell cell_19_min = row.createCell(6);
        cell_19_min.setCellValue(years19 == null ? 0.0 : years19.getMin());
        //2018
        ScoresOverYears years18 = result.findScoreYear("2018");
        Cell cell_18_min_section = row.createCell(7);
        cell_18_min_section.setCellValue(years18 == null ? 0.0 : years18.getMin_section());
        Cell cell_18_min = row.createCell(8);
        cell_18_min.setCellValue(years18 == null ? 0.0 : years18.getMin());
        //2017
        ScoresOverYears years17 = result.findScoreYear("2017");
        Cell cell_17_min_section = row.createCell(9);
        cell_17_min_section.setCellValue(years17 == null ? 0.0 : years17.getMin_section());
        Cell cell_17_min = row.createCell(10);
        cell_17_min.setCellValue(years17 == null ? 0.0 : years17.getMin());
        //2016
        ScoresOverYears years16 = result.findScoreYear("2016");
        Cell cell_16_min_section = row.createCell(11);
        cell_16_min_section.setCellValue(years16 == null ? 0.0 : years16.getMin_section());
        Cell cell_16_min = row.createCell(12);
        cell_16_min.setCellValue(years16 == null ? 0.0 : years16.getMin());
        //2015
        ScoresOverYears years15 = result.findScoreYear("2015");
        Cell cell_15_min_section = row.createCell(13);
        cell_15_min_section.setCellValue(years15 == null ? 0.0 : years15.getMin_section());
        Cell cell_15_min = row.createCell(14);
        cell_15_min.setCellValue(years15 == null ? 0.0 : years15.getMin());
    }

}
