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
public class AccountStatisticsVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long accountId;

    @ExcelExport(value = "账户名称")
    private String accountName;

    @ExcelExport(value = "账户编号")
    private String accountNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "期初金额")
    private BigDecimal initialAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "本月发生金额")
    private BigDecimal thisMonthChangeAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    @ExcelExport(value = "当前余额")
    private BigDecimal currentAmount;
}
