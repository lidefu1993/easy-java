package com.ldf.easy.domain.vo;

import com.ldf.easy.domain.mybatis.Town;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ldf
 * @date 2020/6/27 17:32
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TownVo {

    private String townId;

    private String name;

    public static TownVo builder(Town town){
        TownVo townVo = new TownVo();
        townVo.setTownId(town.getTownId());
        townVo.setName(town.getName());
        return townVo;
    }


}
