package com.wansenai.bo;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Jackson 3 自定义序列化器：
 * JsonSerializer 已重命名为 ValueSerializer
 */
public class BigDecimalSerializerBO extends ValueSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializationContext ctxt) throws JacksonException {
        if (value == null) {
            gen.writeNull();
            return;
        }
        BigDecimal convertedValue = convertToPositiveFormatAndRound(value);
        gen.writeNumber(convertedValue);
    }

    private BigDecimal convertToPositiveFormatAndRound(BigDecimal value) {
        // 绝对值并保留 2 位小数
        return value.abs().setScale(2, RoundingMode.HALF_UP);
    }
}