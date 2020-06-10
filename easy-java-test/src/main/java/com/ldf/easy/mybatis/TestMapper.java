package com.ldf.easy.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lidefu
 * @date 2020年06月09日20:39
 **/
@Mapper
public interface TestMapper {

    List<MybatisTestDO> selectList(@Param("id") Integer id);

}
