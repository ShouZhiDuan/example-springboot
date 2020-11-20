package com.example.dsz.validated;

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

    @PostMapping("/test")
    public Object test(@Validated({Group2.class}) @RequestBody ValidatedDTO validDTO){
        return validDTO;
    }

}
