package com.project.coupon.repository;

import com.project.coupon.entity.CouponIssuance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponIssuanceRepository extends JpaRepository<CouponIssuance, Long> {
    Long countByCouponId(long couponId);
}
