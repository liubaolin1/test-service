package com.demo.service;

import com.demo.entity.News;

import java.util.List;
import java.util.Map;

public interface TestService {
    List<News> selectList();

    void delete(Long id);
}
