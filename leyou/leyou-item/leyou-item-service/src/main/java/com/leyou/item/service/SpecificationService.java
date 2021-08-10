package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper groupMapper;

    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.groupMapper.select(specGroup);
    }

    @Autowired
    private SpecParamMapper paramMapper;

    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.specParamMapper.select(record);
    }


    @Autowired
    private SpecGroupMapper specGroupMapper;
    @Transactional
    public void updateGroups(SpecGroup specGroup) {
        this.specGroupMapper.updateByPrimaryKey(specGroup);
    }
    @Transactional
    public void insertGroups(SpecGroup specGroup) {
        this.specGroupMapper.insertSelective(specGroup);
    }
    @Transactional
    public void deleteGroups(Long id) {
        this.specGroupMapper.deleteByPrimaryKey(id);
    }

    @Autowired
    private SpecParamMapper specParamMapper;
    @Transactional
    public void updateSparams(SpecParam specParam) {
        this.specParamMapper.updateByPrimaryKey(specParam);
    }
    @Transactional
    public void insertParams(SpecParam specParam) {
        this.specParamMapper.insertSelective(specParam);
    }
    @Transactional
    public void deleteParams(Long id) {
        this.specParamMapper.deleteByPrimaryKey(id);
    }

}
