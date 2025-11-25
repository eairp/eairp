package com.wansenai.vo.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String customerName;

    private String contact;

    private String phoneNumber;

    private String email;

    private String fax;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal firstQuarterAccountReceivable;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal secondQuarterAccountReceivable;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal thirdQuarterAccountivable;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal fourthQuarterAccountReceivable;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal totalAccountReceivable;

    private String address;

    private String taxNumber;

    private String bankName;

    private String accountNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal taxRate;

    private Integer status;

    private String remark;

    private Integer sort;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}