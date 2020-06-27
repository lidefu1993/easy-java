package com.ldf.easy.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lidefu
 * @date 2020年06月09日20:39
 **/
@Repository
public interface TestMapper {

    List<MybatisTestDO> selectList(@Param("id") Integer id);

    List<Map<String, Object>> selectCounty();

    int insertLog(@Param("requestId") String requestId);

}
