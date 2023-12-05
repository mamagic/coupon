package com.project.coupon.dto;

import com.project.coupon.entity.Coupon;
import com.project.coupon.entity.CouponIssuance;
import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CouponIssuanceDTO {
    private final String userId;
    private final Long couponId;

    public static CouponIssuanceDTO translate(CouponIssuance couponIssuance){
        return new CouponIssuanceDTO(couponIssuance.getUserId(), couponIssuance.getCouponId());
    }
}