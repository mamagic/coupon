package com.project.coupon.entity;

import com.project.coupon.dto.CouponDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "coupon")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long couponId;

    @Column
    private final Long maxCount;

    public static Coupon translate(CouponDTO couponDTO){
        return new Coupon(couponDTO.getCouponId(), couponDTO.getMaxCount());
    }
}
