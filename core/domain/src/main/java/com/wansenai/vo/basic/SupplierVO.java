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
public class SupplierVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String supplierName;

    private String contact;

    private String contactNumber;

    private String phoneNumber;

    private String address;

    private String email;

    private Integer status;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal firstQuarterAccountPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal secondQuarterAccountPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal thirdQuarterAccountPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal fourthQuarterAccountPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal totalAccountPayment;

    private String fax;

    private String taxNumber;

    private String bankName;

    private String accountNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal taxRate;

    private Integer sort;

    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}