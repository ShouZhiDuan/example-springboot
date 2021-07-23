package com.example.dsz.validated.QianTao;

import com.example.dsz.validated.sequence.Order1;
import com.example.dsz.validated.sequence.Order2;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/20 17:28
 * @Description:
 */
@Data
public class Details {
    @NotNull(message = "详情id不能为空", groups = Order1.class)
    private Long id;
    @NotBlank(message = "详情name不能为空", groups = Order2.class)
    private String name;
}
