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
public class StorageDetailVO {

    @ExcelExport(value = "单据编号")
    private String receiptNumber;

    @ExcelExport(value = "类型")
    private String type;

    // supplier or customer or member
    @ExcelExport(value = "往来人员")
    private String name;

    @ExcelExport(value = "商品条码")
    private String productBarcode;

    @ExcelExport(value = "仓库")
    private String warehouseName;

    @ExcelExport(value = "商品名称")
    private String productName;

    @ExcelExport(value = "规格")
    private String productStandard;

    @ExcelExport(value = "型号")
    private String productModel;

    @ExcelExport(value = "单位")
    private String productUnit;

    @ExcelExport(value = "数量")
    private Integer productNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "单价")
    private BigDecimal unitPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "金额")
    private BigDecimal amount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "税率(%)")
    private BigDecimal taxRate;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "税额")
    private BigDecimal taxAmount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelExport(value = "入库时间")
    private LocalDateTime createTime;
}
