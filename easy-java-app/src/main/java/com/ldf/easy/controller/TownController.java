package com.ldf.easy.controller;

import com.github.pagehelper.PageInfo;
import com.ldf.easy.domain.param.TownQueryParam;
import com.ldf.easy.domain.vo.TownVo;
import com.ldf.easy.service.TownService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author ldf
 * @date 2020/6/27 17:42
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("town")
public class TownController {

    @Autowired
    private TownService townService;

    @ApiOperation(notes = "查看城镇明细", value = "城镇明细")
    @GetMapping("detail")
    public TownVo detail( @RequestParam @Valid @NotNull(message = "主键不允许为空")Integer id){
        return townService.viewTown(id);
    }

    @ApiOperation(notes = "分页查询", value = "分页查询")
    @GetMapping("pageQuery")
    public PageInfo pageQuery(@Validated TownQueryParam param){
        log.debug(param.toString());
        return new PageInfo<>(townService.pageQuery());
    }

}
