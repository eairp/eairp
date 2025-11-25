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
package com.wansenai.vo.receipt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.entities.user.SysUser;
import com.wansenai.vo.basic.OperatorVO;
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
public class ReceiptVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    // 供应商名称 客户名称 会员名称 三者公用字段
    private String name;

    // 供应商id 客户id 会员id 三者公用字段
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long uid;

    private String receiptNumber;

    private String productInfo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiptDate;

    private String operatorId;

    private String operator;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long accountId;

    private Integer productNumber;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal totalAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal taxRateTotalAmount;

    private Integer status;

    // Sale Business Type 2024-07-09 fix
    private List<OperatorVO> operatorIds;
}
