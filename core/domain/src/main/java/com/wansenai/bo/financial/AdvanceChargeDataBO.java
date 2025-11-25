package com.wansenai.bo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AdvanceChargeDataBO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long accountId;

    private String accountName;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal amount;

    private String remark;
}
