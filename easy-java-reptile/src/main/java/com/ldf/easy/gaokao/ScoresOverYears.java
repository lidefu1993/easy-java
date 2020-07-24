package com.ldf.easy.gaokao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lidefu
 * @date 2020年07月24日15:19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoresOverYears {

    //本科一批
    private String local_batch_name;

    //最低位次
    private Double min_section;

    //最低分
    private Double min;

    //省控线
    private Double proscore;

    private String year;


}
