package com.demo.controller;


import com.demo.entity.Article;
import com.demo.entity.News;
import com.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;


/**
 * @Description: 测试freemarker 模板引擎
 * @Author: Po Lam
 * @Date: 2019/6/24 8:59
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerTest {


    @RequestMapping(value = "/list.html",method = RequestMethod.GET)
    public String getArticles(Model model, String title, @RequestParam(defaultValue = "10") Integer pageSize, Integer pageNum) {
        if (pageSize == null) {
            pageSize = 10;
        }
        if (pageNum == null) {
            pageNum = 1;
        }
        int offset = (pageNum - 1) * pageSize;

        List<Article> list = new ArrayList<>();
        Article article = new Article();
        article.setId(1);
        article.setTitle("c");
        article.setSummary("c");
        article.setCreateTime(new Date());
        Article article2 = new Article();
        article2.setId(2);
        article2.setTitle("c2");
        article2.setSummary("c2");
        article2.setCreateTime(new Date());
        list.add(article);
        list.add(article2);
        model.addAttribute("list", list);
        return "freemarkerindex";
    }

    @Autowired
    private TestService testService;
    private static String prod = "http://10.39.1.207:9200/news_new_keyword/detail/";


    private static String test = "http://10.39.0.226:9200/news_new_keyword/detail/";
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        tt_point tt = new tt_point();
        List<News> list = testService.selectList();
        int i = 0;
        /**
         * 读取出所有的 id 倒序排列
         * 然后
         */
        for(News p:list){
            i++;
            System.out.println("size:"+list.size());
            System.out.println("current:"+i);
            System.out.println("最大id: "+p.getId());
            List<Long> list1 = new ArrayList<>();
            for(News m:list){
                if(p.getTitle().equals(m.getTitle()) && p.getId()!= m.getId()) {
                    list1.add(m.getId());
                    tt.delete(prod+m.getId(),"");
                    testService.delete(m.getId());
                }
            }
            System.out.println("其他id:");
            list1.forEach(c-> System.out.println(" "+c));
        }


        return "freemarkerindex";
    }


    @RequestMapping(value = "/bs",method = RequestMethod.GET)
    public String test2() {
        tt_point tt = new tt_point();
        List<News> list = testService.selectList();

        List<News> childList = list;
        /**
         * 读取出所有的 id 倒序排列
         * 然后
         */
        for(int i=0;i<list.size();i++){
            System.out.println("size:"+list.size());
            System.out.println("current:"+i);
            System.out.println("child-size:"+childList.size());
            System.out.println("最大id: "+list.get(i).getId());
            List<Long> list1 = new ArrayList<>();
            for(int j=0;j<childList.size();j++){
                if(list.get(i).getTitle().equals(childList.get(j).getTitle()) && list.get(i).getId()!= childList.get(j).getId()) {
                    list1.add(childList.get(j).getId());
                    tt.delete(prod+childList.get(j).getId(),"");
                    testService.delete(childList.get(j).getId());
                    childList.remove(j);
                }
            }
            System.out.println("其他id:");
            list1.forEach(c-> System.out.println(" "+c));
        }


        return "freemarkerindex";
    }



}
