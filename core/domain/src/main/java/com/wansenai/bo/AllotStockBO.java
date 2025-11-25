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
package com.wansenai.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AllotStockBO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long warehouseId;

    private String warehouseName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long otherWarehouseId;

    private String otherWarehouseName;

    private String barCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long productId;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal salePrice;

    private String productName;

    private String productStandard;

    private String productModel;

    private String productUnit;

    private Integer stock;

    private Integer productNumber;

    private String remark;
}
