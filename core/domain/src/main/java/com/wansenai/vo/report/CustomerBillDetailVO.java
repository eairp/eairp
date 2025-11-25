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
import java.time.LocalDateTime;

@Data
@Builder
public class CustomerBillDetailVO {

    @ExcelExport(value = "单据编号")
    private String receiptNumber;

    @ExcelExport(value = "客户")
    private String customerName;

    @ExcelExport(value = "商品信息")
    private String productInfo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelExport(value = "单据日期")
    private LocalDateTime receiptDate;

    @ExcelExport(value = "操作员")
    private String operator;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "本单欠款")
    private BigDecimal thisReceiptArrears;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "已收欠款")
    private BigDecimal receivedArrears;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "待收欠款")
    private BigDecimal receivableArrears;
}
