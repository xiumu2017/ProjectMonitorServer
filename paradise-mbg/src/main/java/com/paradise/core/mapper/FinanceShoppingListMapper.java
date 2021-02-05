package com.paradise.core.mapper;

import com.paradise.core.example.FinanceShoppingListExample;
import com.paradise.core.model.FinanceShoppingList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinanceShoppingListMapper {
    long countByExample(FinanceShoppingListExample example);

    int deleteByExample(FinanceShoppingListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinanceShoppingList record);

    int insertSelective(@Param("record") FinanceShoppingList record, @Param("selective") FinanceShoppingList.Column... selective);

    FinanceShoppingList selectOneByExample(FinanceShoppingListExample example);

    FinanceShoppingList selectOneByExampleSelective(@Param("example") FinanceShoppingListExample example, @Param("selective") FinanceShoppingList.Column... selective);

    List<FinanceShoppingList> selectByExampleSelective(@Param("example") FinanceShoppingListExample example, @Param("selective") FinanceShoppingList.Column... selective);

    List<FinanceShoppingList> selectByExample(FinanceShoppingListExample example);

    FinanceShoppingList selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") FinanceShoppingList.Column... selective);

    FinanceShoppingList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinanceShoppingList record, @Param("example") FinanceShoppingListExample example, @Param("selective") FinanceShoppingList.Column... selective);

    int updateByExample(@Param("record") FinanceShoppingList record, @Param("example") FinanceShoppingListExample example);

    int updateByPrimaryKeySelective(@Param("record") FinanceShoppingList record, @Param("selective") FinanceShoppingList.Column... selective);

    int updateByPrimaryKey(FinanceShoppingList record);

    int batchInsert(@Param("list") List<FinanceShoppingList> list);

    int batchInsertSelective(@Param("list") List<FinanceShoppingList> list, @Param("selective") FinanceShoppingList.Column... selective);
}