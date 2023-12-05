package com.project.coupon.service;

import com.project.coupon.dto.CouponDTO;
import com.project.coupon.entity.Coupon;
import com.project.coupon.repository.CouponRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public void save(CouponDTO couponDTO){
        couponRepository.save(Coupon.translate(couponDTO));
    }

    @Transactional
    public Long couponMaxCount(Long couponId){
        return couponRepository.findById(couponId).get().getMaxCount();
    }

}
