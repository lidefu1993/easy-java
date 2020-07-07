package com.ldf.easy.service;

import com.ldf.easy.domain.vo.TownVo;

import java.util.List;

/**
 * @author ldf
 * @date 2020/6/27 17:31
 **/
public interface TownService {

    /**
     * 查看城镇信息
     * @param id 主键
     * @return -
     */
    TownVo viewTown(Integer id);

    /**
     * 分页查询
     * @return -
     */
    List<TownVo> pageQuery();

}
