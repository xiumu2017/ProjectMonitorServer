package com.paradise.core.app.dao;

import com.paradise.core.dto.query.ErArticleQuery;
import com.paradise.core.model.ErArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MpArticleDao {
    /**
     * 小程序分页查询
     *
     * @param query {@link ErArticleQuery}
     * @return {@link ErArticle}
     */
    List<ErArticle> pageQuery(@Param("query") ErArticleQuery query);
}
