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
package com.wansenai.vo.financial;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.bo.FileDataBO;
import com.wansenai.bo.IncomeExpenseBO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IncomeDetailVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long relatedPersonId;

    private String relatedPersonName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiptDate;

    private String receiptNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long financialPersonId;

    private String financialPersonName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long incomeAccountId;

    private String incomeAccountName;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal incomeAmount;

    private String remark;

    private List<IncomeExpenseBO> tableData;

    private List<FileDataBO> files;

    private Integer status;
}
