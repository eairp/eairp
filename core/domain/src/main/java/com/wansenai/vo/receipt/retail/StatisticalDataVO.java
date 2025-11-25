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
package com.wansenai.vo.receipt.retail;

import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.bo.XyAxisDataBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticalDataVO {

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal todaySales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal yesterdaySales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal todayRetailSales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal yesterdayRetailSales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal todayPurchase;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal yesterdayPurchase;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal monthSales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal monthRetailSales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal monthPurchase;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal yearSales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal yearRetailSales;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal yearPurchase;

    private List<XyAxisDataBO> retailAxisStatisticalDataVO;

    private List<XyAxisDataBO> saleAxisStatisticalDataVO;

    private List<XyAxisDataBO> purchaseAxisStatisticalDataVO;

}
