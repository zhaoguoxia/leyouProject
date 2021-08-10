package com.leyou1.item.controller;


import com.leyou1.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import pojo.Brand;
import pojo.PageResult;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService service;
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandsByPage(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy", required = false)String sortBy,
            @RequestParam(value = "desc", required = false)Boolean desc
    ){
        PageResult<Brand> result = service.queryBrandsByPage(key, page, rows, sortBy, desc);
        if (CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
    /**
     * 新增品牌
     * @param brand
     * @param cids
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids){
        service.saveBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //品牌的修改
    @PutMapping
    public ResponseEntity<Void> updateBrand(Brand brand,@RequestParam(value = "cids") List<Long> cids ) {
        service.updateBrand(brand, cids);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    //删除品牌
    @GetMapping("/del")
    public ResponseEntity<Void> deleteBrand(@RequestParam(value = "id") Long id){
        System.out.println(id);
        service.deleteBrand(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    //根据商品分类查询品牌信息
    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>> queryBrandsByCid(@PathVariable("cid")Long cid){
        List<Brand> brands = service.queryBrandsByCid(cid);
        if (CollectionUtils.isEmpty(brands)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brands);
    }


}


