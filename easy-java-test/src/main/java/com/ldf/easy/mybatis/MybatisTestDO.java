package com.ldf.easy.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lidefu
 * @date 2020年06月09日20:42
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MybatisTestDO {

    private Integer id;
    private String name;
    private Integer age;
    private String description;

}
