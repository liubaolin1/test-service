package com.demo.service;

import com.demo.dao.NewsMapper;
import com.demo.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> selectList() {
        return newsMapper.selectCrmList();
    }

    @Override
    public void delete(Long id) {
        newsMapper.delete(id);
    }
}
