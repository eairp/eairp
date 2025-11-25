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
public class PurchaseReportVO {

    @ExcelExport(value = "商品条码")
    private String productBarcode;

    @ExcelExport(value = "仓库")
    private String warehouseName;

    @ExcelExport(value = "商品名称")
    private String productName;

    @ExcelExport(value = "型号")
    private String productModel;

    @ExcelExport(value = "规格")
    private String productStandard;

    @ExcelExport(value = "扩展信息")
    private String productExtendInfo;

    @ExcelExport(value = "供应商")
    private String supplier;

    @ExcelExport(value = "单位")
    private String productUnit;

    @ExcelExport(value = "采购数量")
    private Integer purchaseNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "采购金额")
    private BigDecimal purchaseAmount;

    @ExcelExport(value = "采购退货数量")
    private Integer purchaseRefundNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "采购退货金额")
    private BigDecimal purchaseRefundAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "实际采购金额")
    private BigDecimal purchaseLastAmount;

    @ExcelExport(value = "采购时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
