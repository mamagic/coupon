package com.project.coupon.dto;

import com.project.coupon.entity.Coupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CouponDTO {
    private final Long couponId;
    private final Long maxCount;

    public static CouponDTO translate(Coupon coupon){
        return new CouponDTO(coupon.getCouponId(), coupon.getMaxCount());
    }
}