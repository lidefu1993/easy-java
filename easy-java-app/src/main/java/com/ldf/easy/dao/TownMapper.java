package com.ldf.easy.dao;

import com.ldf.easy.domain.mybatis.Town;
import com.ldf.easy.domain.vo.TownVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Town record);

    int insertSelective(Town record);

    Town selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Town record);

    int updateByPrimaryKey(Town record);

    List<TownVo> selectAll();
}