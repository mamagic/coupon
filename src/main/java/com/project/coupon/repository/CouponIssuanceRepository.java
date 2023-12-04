package com.project.coupon.repository;

import com.project.coupon.entity.CouponIssuance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponIssuanceRepository extends JpaRepository<CouponIssuance, Long> {
}
