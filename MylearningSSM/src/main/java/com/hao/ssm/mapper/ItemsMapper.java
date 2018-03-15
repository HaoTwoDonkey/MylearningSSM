package com.hao.ssm.mapper;

import com.hao.ssm.pojo.Items;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);

    List<Items> findItemsListByName(String name);

    Integer addOrderItem(Items items);
}