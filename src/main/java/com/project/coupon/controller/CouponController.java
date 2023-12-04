package com.project.coupon.controller;

import com.project.coupon.controller.request.CouponIssuanceRequest;
import com.project.coupon.dto.CouponDTO;
import com.project.coupon.service.CouponIssuanceService;
import com.project.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    CouponIssuanceService couponIssuanceService;

    @Autowired
    CouponService couponService;

    @PostMapping("/coupon-issuance")
    public void couponIssuance(@RequestBody CouponIssuanceRequest request){

        couponIssuanceService.save(request.translate(request));
    }
}
