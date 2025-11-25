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
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductStockSkuVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long warehouseId;

    @ExcelExport(value = "条码")
    private String productBarcode;

    @ExcelExport(value = "仓库")
    private String warehouseName;

    @ExcelExport(value = "商品名称")
    private String productName;

    @ExcelExport(value = "商品分类")
    private String productCategoryName;

    @ExcelExport(value = "规格")
    private String productStandard;

    @ExcelExport(value = "型号")
    private String productModel;

    @ExcelExport(value = "颜色")
    private String productColor;

    @ExcelExport(value = "单位")
    private String productUnit;

    @ExcelExport(value = "仓位货架")
    private String warehouseShelves;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "重量")
    private BigDecimal productWeight;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "单价")
    private BigDecimal unitPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal retailPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal salePrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal purchasePrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "初始库存")
    private BigDecimal initialStock;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "当前库存")
    private BigDecimal currentStock;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "库存金额")
    private BigDecimal stockAmount;
}
