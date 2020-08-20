package com.ldf.easy.jackson;

import com.fasterxml.jackson.databind.ser.std.NumberSerializer;

/**
 * @author lidefu
 * @date 2020年08月15日15:18
 **/
public class MyNumberSerializer extends NumberSerializer {

    /**
     * @param rawType
     * @since 2.5
     */
    public MyNumberSerializer(Class<? extends Number> rawType) {
        super(rawType);
    }

}
