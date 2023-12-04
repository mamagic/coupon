package com.project.coupon.controller.request;

import com.project.coupon.dto.CouponIssuanceDTO;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CouponIssuanceRequest {
    private final String userId;
    private final Long couponId;

    public CouponIssuanceDTO translate(CouponIssuanceRequest request) {
        return new CouponIssuanceDTO(request.getUserId(), request.getCouponId());
    }
}
