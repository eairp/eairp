package com.wansenai.vo.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUnitVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String basicUnit;

    private String otherUnit;

    private String computeUnit;

    private String otherComputeUnit;

    private String otherUnitTwo;

    private String otherComputeUnitTwo;

    private String otherUnitThree;

    private String otherComputeUnitThree;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal ratio;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal ratioTwo;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal ratioThree;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}