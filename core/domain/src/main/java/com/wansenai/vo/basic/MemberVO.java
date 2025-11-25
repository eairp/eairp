package com.wansenai.vo.basic;

import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import com.wansenai.bo.BigDecimalSerializerBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String memberNumber;

    private String memberName;

    private String phoneNumber;

    private String email;

    @JsonSerialize(using = BigDecimalSerializerBO.class)
    private BigDecimal advancePayment;

    private Integer status;

    private String remark;

    private Integer sort;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}