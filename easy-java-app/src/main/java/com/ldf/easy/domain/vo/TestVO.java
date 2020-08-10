package com.ldf.easy.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lidefu
 * @date 2020年08月10日11:27
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestVO {

    @Ignore
    private Integer id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDt;

}
