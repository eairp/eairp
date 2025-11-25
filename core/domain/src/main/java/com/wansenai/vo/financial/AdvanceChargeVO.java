package com.wansenai.vo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvanceChargeVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String memberName;

    private String receiptNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiptDate;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal collectedAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal totalAmount;

    private String financialPersonnel;

    private String operator;

    private String remark;

    private Integer status;
}