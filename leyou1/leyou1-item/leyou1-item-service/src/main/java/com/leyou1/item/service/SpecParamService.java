package com.leyou1.item.service;

import com.leyou1.item.mapper.SpecParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.SpecParam;

import java.util.List;

@Service
public class SpecParamService {
    @Autowired
    private SpecParamMapper paramMapper;

    /**
     * 根据条件查询规格参数
     *
     * @param gid
     * @return
     */
    public List<SpecParam> queryParams(Long gid,Long cid,Boolean generic,Boolean searching) {
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        param.setCid(cid);
        param.setGeneric(generic);
        param.setSearching(searching);
        return paramMapper.select(param);
    }
}
