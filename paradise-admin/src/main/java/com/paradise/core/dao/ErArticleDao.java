package com.paradise.core.dao;

import com.paradise.core.dto.query.ErArticleQuery;
import com.paradise.core.model.ErArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Paradise
 */
public interface ErArticleDao {
    /**
     * 分页查询
     *
     * @param query {@link ErArticleQuery}
     * @return {@link ErArticle}
     */
    List<ErArticle> selectByPage(@Param("query") ErArticleQuery query);
}
