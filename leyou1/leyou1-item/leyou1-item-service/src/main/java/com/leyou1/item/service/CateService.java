package com.leyou1.item.service;


import pojo.Category;

import java.util.List;

public interface CateService {
    //根据parent_id查询
    public List<Category> findCategory(Long id);
}
