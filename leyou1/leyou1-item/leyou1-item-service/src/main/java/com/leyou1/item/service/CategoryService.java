package com.leyou1.item.service;


import com.leyou1.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Category;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements  CateService {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> findCategory(Long id) {
        Category record = new Category();
        record.setParentId(id);
        return mapper.select(record);
    }

    public List<Category> queryByBrandId(Long bid) {
        return mapper.queryByBrandId(bid);
    }

    public List<String> queryNamesByIds(List<Long> ids) {
        List<Category> list = mapper.selectByIdList(ids);
        List<String> names = new ArrayList<>();
        for (Category category : list) {
            names.add(category.getName());
        }
        return names;
    }
}
