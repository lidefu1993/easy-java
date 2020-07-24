package com.ldf.easy.gaokao;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ldf.easy.htmlunit.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lidefu
 * @date 2020年07月24日17:51
 **/
public class Test {
    private  static String url = "https://gkcx.eol.cn/school/459/provinceline";
    public static void main(String[] args) throws IOException {
        test3();
    }

    private static void test1() throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(600*1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage(url);
        System.out.println(page);
    }

    private static void test2() throws IOException {

        Map<String, List<String>> result = new HashMap<>(5);
        WebClient webClient = Util.webClientBuilder();
        HtmlPage rootPage = webClient.getPage(url);
        //设置一个运行JavaScript的时间
        webClient.waitForBackgroundJavaScript(5*1000);
        String html = rootPage.asXml();
        Document document = Jsoup.parse(html);
        System.out.println(1);
    }

    private static void test3() throws IOException {
        WebClient client = new WebClient(BrowserVersion.FIREFOX_52);
        //默认执行js，如果不执行js，则可能会登录失败，因为用户名密码框需要js来绘制。
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setCssEnabled(false);
        client.setAjaxController(new NicelyResynchronizingAjaxController());
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);
        client.getOptions().setThrowExceptionOnScriptError(false);
        WebRequest request = Util.webRequest(url, cookies);
        HtmlPage page = client.getPage(request);
        client.waitForBackgroundJavaScript(30*1000);
        String xml = page.asXml();
        Document document = Jsoup.parse(xml);
        Elements elements = document.getElementsByAttributeValue("class", "WB_detail");
        Elements byAttributeValue = document.getElementsByAttributeValue("class", "WB_text");
        Elements aClass = document.getElementsByAttributeValue("class", "line S_line1");
        Elements pageNext = document.getElementsByAttributeValue("class", "page next S_txt1 S_line1");
        System.out.println(1);
        client.close();
    }

    private static String cookies = "UM_distinctid=1737a9c4ceb26d-045bf56d70cffa-57b143a-1fa400-1737a9c4cec491; CNZZDATA1254842204=1061406280-1595488375-%7C1595488375; CNZZDATA1254842246=1938640381-1595488336-%7C1595488336; CNZZDATA1000438935=2093198967-1595490413-%7C1595490413; CNZZDATA1254843501=309401675-1595490090-%7C1595490090; CNZZDATA1254877282=2108645273-1595490967-%7C1595490967; CNZZDATA1254844149=216533186-1595488262-%7C1595488262; Hm_lvt_9b4517aa97b6b67e7c396bef15886cef=1595489930,1595570514; CNZZDATA1000439941=2082551424-1595489931-%7C1595570516; CNZZDATA1254838063=1852787554-1595572313-%7C1595572313; CNZZDATA1261518421=1204951484-1595568851-%7C1595568851; CNZZDATA1000439481=1488315961-1595571236-%7C1595571236; CNZZDATA1254852102=873904087-1595579339-%7C1595579339; CNZZDATA1253111639=476119126-1595575626-%7C1595575626; CNZZDATA1254845951=2089444914-1595578731-%7C1595578731; CNZZDATA1259420532=1541542510-1595578946-%7C1595578946; CNZZDATA1000439534=355829676-1595576097-%7C1595576097; CNZZDATA1254841828=1088294542-1595486012-%7C1595581327; CNZZDATA4696252=cnzz_eid%3D1126676830-1595484545-%26ntime%3D1595582238; Hm_lpvt_9b4517aa97b6b67e7c396bef15886cef=1595584693; eol_avd_got=1595584693158; lastvisit=1595584693158";

}
