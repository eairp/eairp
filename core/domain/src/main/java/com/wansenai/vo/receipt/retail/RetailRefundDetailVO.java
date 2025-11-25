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

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import com.wansenai.bo.FileDataBO;
import com.wansenai.bo.ShipmentsDataBO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class RetailRefundDetailVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long memberId;

    private String memberName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long accountId;

    private String accountName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiptDate;

    private String receiptNumber;

    private String otherReceipt;

    private String paymentType;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal paymentAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal receiptAmount;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal backAmount;

    private String remark;

    private List<ShipmentsDataBO> tableData;

    private List<FileDataBO> files;

    private Integer status;
}
