package com.example.dsz.validated.sequence;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/20 17:19
 * @Description:
 */
@Data
public class OrderDTO {

    @NotNull(message = "请输入ID",groups = Order1.class)
    private Integer id;

    @NotBlank(message = "请输入name",groups = Order2.class)
    private String name;

}
