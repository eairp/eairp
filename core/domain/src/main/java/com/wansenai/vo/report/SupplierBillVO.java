/*
 * Copyright 2023-2025 EAIRP Team, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://opensource.wansenai.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.wansenai.vo.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.utils.excel.ExcelExport;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SupplierBillVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long supplierId;

    @ExcelExport(value = "供应商")
    private String supplierName;

    @ExcelExport(value = "联系人")
    private String contactName;

    @ExcelExport(value = "联系电话")
    private String contactPhone;

    @ExcelExport(value = "电子邮箱")
    private String email;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "一季度应付账款")
    private BigDecimal firstQuarterPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "二季度应付账款")
    private BigDecimal secondQuarterPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "三季度应付账款")
    private BigDecimal thirdQuarterPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "四季度应付账款")
    private BigDecimal fourthQuarterPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "累计欠款")
    private BigDecimal totalArrears;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "累计付款")
    private BigDecimal totalPayment;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "应付欠款")
    private BigDecimal remainingPaymentArrears;
}
