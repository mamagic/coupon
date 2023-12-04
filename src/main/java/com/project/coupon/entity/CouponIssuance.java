package com.project.coupon.entity;

import com.project.coupon.dto.CouponIssuanceDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "coupon_issuance")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CouponIssuance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long couponIssuanceId;

    @Column
    private final String userId;

    @Column
    private final Long couponId;

    public static CouponIssuance translate(CouponIssuanceDTO couponIssuanceDTO) {
        return new CouponIssuance(null, couponIssuanceDTO.getUserId(), couponIssuanceDTO.getCouponId());
    }
}
