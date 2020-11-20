package com.example.dsz.validated;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/20 16:39
 * @Description:
 */
@Data
public class ValidatedDTO {
    @NotNull(message = "请输入id",groups = Group1.class)
    private Long id;
    @NotBlank(message = "请输入名称",groups = {Group1.class,Group2.class})
    private String name;
}
