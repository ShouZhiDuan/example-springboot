package com.example.dsz.validated;

import com.example.dsz.validated.QianTao.Item;
import com.example.dsz.validated.sequence.OrderDTO;
import com.example.dsz.validated.sequence.SequnceGroup;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/11/20 16:41
 * @Description:
 */
@RestController
@RequestMapping("/valid")
public class ValidTestController {

    /**
     * 分组验证
     */
    @PostMapping("/test")
    public Object test(@Validated({Group2.class}) @RequestBody ValidatedDTO validDTO) {
        return validDTO;
    }

    /**
     * 顺序验证
     */
    @PostMapping("/test2")
    public Object test2(@Validated({SequnceGroup.class}) @RequestBody OrderDTO orderDTO) {
        return orderDTO;
    }


    /**
     * 嵌套验证 + 顺序验证
     */
    @PostMapping("/test3")
    public Object test3(@Validated(SequnceGroup.class) @RequestBody Item item) {
        return item;
    }

}
