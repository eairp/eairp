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
public class ExportProductEnBO {

    @ExcelExport(value = "Name of commodity")
    private String productName;

    @ExcelExport(value = "Bar code")
    private String productBarcode;

    @ExcelExport(value = "Commodity measurement unit")
    private String productUnit;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "Current inventory quantity")
    private BigDecimal stock;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "Retail price")
    private BigDecimal retailPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "Market price")
    private BigDecimal salesPrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "Purchase price")
    private BigDecimal purchasePrice;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "Minimum selling price")
    private BigDecimal lowSalesPrice;

    @ExcelExport(value = "Specifications")
    private String productStandard;

    @ExcelExport(value = "Model")
    private String productModel;

    @ExcelExport(value = "Color")
    private String productColor;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "Base weight")
    private BigDecimal productWeight;

    @ExcelExport(value = "Guarantee period")
    private Integer productExpiryNum;

    @ExcelExport(value = "Category")
    private String productCategoryName;

    @ExcelExport(value = "Serial number")
    private String enableSerialNumber;

    @ExcelExport(value = "Batch number")
    private String enableBatchNumber;

    @ExcelExport(value = "Position shelf")
    private String warehouseShelves;

    @ExcelExport(value = "Manufacturer")
    private String productManufacturer;

    @ExcelExport(value = "Multiple attributes")
    private String multiAttribute;

    @ExcelExport(value = "Extended field 1")
    private String otherFieldOne;

    @ExcelExport(value = "Extended field 2")
    private String otherFieldTwo;

    @ExcelExport(value = "Extended field 3")
    private String otherFieldThree;

    @ExcelExport(value = "Remark")
    private String remark;
}
