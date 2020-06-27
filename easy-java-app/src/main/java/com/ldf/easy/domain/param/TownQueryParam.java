package com.ldf.easy.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ldf
 * @date 2020/6/27 19:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TownQueryParam {

    @NotNull(message = "姓名不允许为空")
    @NotEmpty(message = "姓名不允许为空")
    private String name;


}
