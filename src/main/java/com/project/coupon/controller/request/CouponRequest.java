package com.project.coupon.controller.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CouponRequest {
    private final Long couponId;
    private final Long maxCount;
}
