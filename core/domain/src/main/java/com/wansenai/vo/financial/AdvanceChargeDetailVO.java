package com.wansenai.vo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.bo.FileDataBO;
import com.wansenai.bo.financial.AdvanceChargeDataBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvanceChargeDetailVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long memberId;

    private String memberName;

    private String receiptNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiptDate;

    private String financialPersonnel;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long financialPersonnelId;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal totalAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal collectedAmount;

    private List<AdvanceChargeDataBO> tableData;

    private List<FileDataBO> files;

    private String remark;

    private Integer status;
}