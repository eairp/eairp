/*
 * Copyright 2024-2033 WanSen AI Team, Inc. All Rights Reserved.
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
package com.wansenai.bo.product;

import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.utils.excel.ExcelExport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportProductBO {

    @ExcelExport(value = "商品名称")
    private String productName;

    @ExcelExport(value = "条码")
    private String productBarcode;

    @ExcelExport(value = "商品单位")
    private String productUnit;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "库存")
    private BigDecimal stock;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "零售价格")
    private BigDecimal retailPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "销售价格")
    private BigDecimal salesPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "采购价格")
    private BigDecimal purchasePrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "最低销售价格")
    private BigDecimal lowSalesPrice;

    @ExcelExport(value = "规格")
    private String productStandard;

    @ExcelExport(value = "型号")
    private String productModel;

    @ExcelExport(value = "颜色")
    private String productColor;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "商品重量")
    private BigDecimal productWeight;

    @ExcelExport(value = "保质期")
    private Integer productExpiryNum;

    @ExcelExport(value = "类别")
    private String productCategoryName;

    @ExcelExport(value = "序列号")
    private String enableSerialNumber;

    @ExcelExport(value = "批次号")
    private String enableBatchNumber;

    @ExcelExport(value = "仓库货架")
    private String warehouseShelves;

    @ExcelExport(value = "制造商")
    private String productManufacturer;

    @ExcelExport(value = "商品属性")
    private String multiAttribute;

    @ExcelExport(value = "自定义1")
    private String otherFieldOne;

    @ExcelExport(value = "自定义2")
    private String otherFieldTwo;

    @ExcelExport(value = "自定义3")
    private String otherFieldThree;

    @ExcelExport(value = "备注")
    private String remark;
}
