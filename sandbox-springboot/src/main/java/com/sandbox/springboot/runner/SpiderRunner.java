package com.sandbox.springboot.runner;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Set;

//@Component
public class SpiderRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello World!");

        // 创建webclient
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        String prefixUrl = "https://usedcarpv.che168.com/pv.ashx";
        WebRequest request = new WebRequest(new URL(prefixUrl));
//        request.setProxyHost("localhost");
//        request.setProxyPort(8888);
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

        webClient.getPage(request);
        Set<Cookie> cookies = webClient.getCookieManager().getCookies();
        Cookie sessionIdCookie = cookies.stream().filter(c -> c.getName().contains("sessionid")).findFirst().get();
        String sessionId = sessionIdCookie.getValue();


        webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getCookieManager().addCookie(sessionIdCookie);
        String url_template = "https://callcenterapi.che168.com/CallCenterApi/v100/BindingNumber.ashx?_appid=2sc.pc&_callback=getxphonenumbercallback&fromtype=0&infoid=31079956&uniqueid={0}&ts=0&_sign=Ehedie3January&sessionid={0}&detailpageurl=https%253A%2F%2Fwww.che168.com%2Fpersonal%2F31079956.html%253Fpvareaid%253D100522&detailpageref=&adfrom=0&queryid=&cartype=0";
        String url = MessageFormat.format(url_template, sessionId);
        request = new WebRequest(new URL(url));
        request.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

        // 取消 JS 支持
        //webClient.getCookieManager().setCookiesEnabled(true);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setActiveXNative(false);
//        webClient.getOptions().setAppletEnabled(false);
//        webClient.getOptions().setDownloadImages(false);
        // 取消 CSS 支持
//        webClient.getOptions().setCssEnabled(false);
//        webClient.getOptions().setUseInsecureSSL(true);
        // 获取指定网页实体
//        HtmlPage page = (HtmlPage) webClient.getPage("https://www.che168.com/personal/31079956.html?pvareaid=100522");
//        Page page1 = webClient.getPage(request);
//        HtmlPage page = (HtmlPage) webClient.getPage(request);
        Page page = webClient.getPage(request);

        System.out.println(page.getWebResponse().getContentAsString());


//        cookies.stream().forEach(item->{
//            System.out.println(item.getName()+":"+item.getValue());
//        });



        // HtmlElement btn = page.querySelector("a[id=loginAction]");


//        page.getHtmlElementDescendants().forEach(
//                c -> {
//                    boolean b = c.getAttribute("class").equals("phone-tip fn-clear");
//                    if (b) {
//                        try {
////                            c.click();
////                            c.getHtmlElementDescendants().iterator().next().click();
//                            c.getHtmlElementDescendants().iterator().next().getHtmlElementDescendants().iterator().next().click();
//                            String tel = c.getHtmlElementDescendants().iterator().next().getTextContent();
//                            System.out.println(MessageFormat.format("抓取地址：{0}", url));
//                            System.out.println(MessageFormat.format("抓取手机号：{0}", tel));
////                            c.getHtmlElementDescendants().iterator().next().getHtmlElementDescendants().iterator().next();
////                            c.click();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//        );
    }




}


