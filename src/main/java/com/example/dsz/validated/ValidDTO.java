package com.example.dsz.validated;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/20 16:37
 * @Description:
 */
@Data
public class ValidDTO {
    @NotNull(message = "id不能为空")
    private Long id;
    @NotBlank(message = "请输入名称")
    private String name;
}
