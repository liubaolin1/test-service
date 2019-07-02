package com.demo.controller;

import com.demo.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
}
