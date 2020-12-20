package com.paradise.core.service.impl;

import com.paradise.core.example.UmsResourceCategoryExample;
import com.paradise.core.mapper.UmsResourceCategoryMapper;
import com.paradise.core.model.UmsResourceCategory;
import com.paradise.core.service.UmsResourceCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 后台资源分类管理Service实现类
 *
 * @author Paradise
 * @date 2020/2/5
 */
@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    private final UmsResourceCategoryMapper resourceCategoryMapper;

    public UmsResourceCategoryServiceImpl(UmsResourceCategoryMapper resourceCategoryMapper) {
        this.resourceCategoryMapper = resourceCategoryMapper;
    }

    @Override
    public List<UmsResourceCategory> listAll() {
        UmsResourceCategoryExample example = new UmsResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return resourceCategoryMapper.insert(umsResourceCategory);
    }

    @Override
    public int update(Long id, UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        return resourceCategoryMapper.updateByPrimaryKeySelective(umsResourceCategory);
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }
}
