package com.ldf.easy.gaokao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * @author lidefu
 * @date 2020年07月24日14:44
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GaoKaoAnalysisResult {

    private String id;

    private String name;

    /**
     * 省
     */
    private String belong;

    private String city_name;

    /**
     *  例如：普通本科
     */
    private String level_name;

    /**
     * 公办私办
     */
    private String nature_name;

    /**
     * 历年分数
     */
    private List<ScoresOverYears> scoresOverYears;

    public Integer schoolId(){
        String replace = this.id.replace("gkschool", "");
        return Integer.valueOf(replace);
    }

    private static final List<String> IGNORE_PROVINCE = Arrays.asList("内蒙古", "新疆", "西藏", "海南", "云南");
    private static final List<String> IN_YEAR = Arrays.asList("2019", "2018");

    /**
     *  按位次过滤
     * @param section 位次
     * @return true
     */
    public boolean filter(int section){
        return this.scoresOverYears != null && this.scoresOverYears.stream().anyMatch(s -> s.getMin_section() >= section
                && IN_YEAR.contains(s.getYear())
                && !"专科批".equals(s.getLocal_batch_name())
        );
    }

    public ScoresOverYears findScoreYear(String yearParam){
        return this.scoresOverYears.stream().filter(item->yearParam.equals(item.getYear())).findFirst().orElse(null);
    }

}
