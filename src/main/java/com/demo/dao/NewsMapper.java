package com.demo.dao;

import com.demo.entity.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewsMapper {
    List<News> selectCrmList();

    void delete(Long id);
}