package com.example.dsz.validated.QianTao;

import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/20 17:28
 * @Description:
 */
@Data
public class Item {
    @NotBlank(message = "Item的id不能为空")
    private String id;
    @Valid
    @NotNull(message = "props不能为空")
    @Size(min = 1, message = "至少输入一个详情")
    private List<Details> details;
}
