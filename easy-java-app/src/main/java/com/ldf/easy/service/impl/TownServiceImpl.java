package com.ldf.easy.service.impl;

import com.github.pagehelper.PageHelper;
import com.ldf.easy.dao.TownMapper;
import com.ldf.easy.domain.mybatis.Town;
import com.ldf.easy.domain.vo.TownVo;
import com.ldf.easy.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ldf
 * @date 2020/6/27 17:36
 **/
@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private TownMapper townMapper;

    @Override
    public TownVo viewTown(Integer id) {
        Town town = townMapper.selectByPrimaryKey(id);
        return TownVo.builder(town);
    }

    @Override
    public List<TownVo> pageQuery() {
        PageHelper.startPage(1, 10);
        return townMapper.selectAll();
    }
}
