package com.project.coupon.service;

import com.project.coupon.dto.CouponDTO;
import com.project.coupon.dto.CouponIssuanceDTO;
import com.project.coupon.entity.Coupon;
import com.project.coupon.entity.CouponIssuance;
import com.project.coupon.repository.CouponIssuanceRepository;
import com.project.coupon.repository.CouponRepository;
import jakarta.transaction.Synchronization;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CouponIssuanceService {

    private final CouponIssuanceRepository couponIssuanceRepository;
    private final CouponService couponService;

    private final long COUPON_ID = 1L;
    private AtomicLong SAVE_COUNT = new AtomicLong(0L);
    @Transactional
    public void save(CouponIssuanceDTO couponIssuanceDTO){

        long couponIssuanceCountById = count(COUPON_ID);

        System.out.println(couponIssuanceDTO.getUserId() + " 입력");

        //예외 처리 추가
        if (SAVE_COUNT.incrementAndGet() <= 100) {
            couponIssuanceRepository.save(CouponIssuance.translate(couponIssuanceDTO));
        }
    }
@Transactional
    public long count(long couponId){
        return couponIssuanceRepository.countByCouponId(couponId);
    }

}
