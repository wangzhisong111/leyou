package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsByCid(@PathVariable("cid")Long cid){
        List<SpecGroup> groups = this.specificationService.queryGroupsByCid(cid);
        if (CollectionUtils.isEmpty(groups)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }
    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParams(
            @RequestParam(value = "gid", required = false)Long gid,
            @RequestParam(value = "cid", required = false)Long cid,
            @RequestParam(value = "generic", required = false)Boolean generic,
            @RequestParam(value = "searching", required = false)Boolean searching
    ){

        List<SpecParam> params = this.specificationService.queryParams(gid, cid, generic, searching);

        if (CollectionUtils.isEmpty(params)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(params);
    }

    //更新规格组
    @PutMapping("group")
    public ResponseEntity<Void> updateGroups(@RequestBody SpecGroup specGroup){
        this.specificationService.updateGroups(specGroup);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //新增规格组
    @PostMapping("group")
    public ResponseEntity<Void> insertGroups(@RequestBody SpecGroup specGroup){
        this.specificationService.insertGroups(specGroup);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //删除规格组
    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteGroups(@PathVariable("id")Long id){
        this.specificationService.deleteGroups(id);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //更新规格参数
    @PutMapping("param")
    public ResponseEntity<Void> updateSparams(@RequestBody SpecParam specParam){
        this.specificationService.updateSparams(specParam);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //新增规格组
    @PostMapping("param")
    public ResponseEntity<Void> insertParams(@RequestBody SpecParam specParam){
        this.specificationService.insertParams(specParam);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //删除规格组
    @DeleteMapping("param/{id}")
    public ResponseEntity<Void> deleteParams(@PathVariable("id")Long id){
        this.specificationService.deleteParams(id);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

}