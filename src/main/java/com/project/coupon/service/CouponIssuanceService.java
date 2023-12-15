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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CouponIssuanceService {

    private final CouponIssuanceRepository couponIssuanceRepository;
    private final CouponService couponService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final long COUPON_ID = 1L;
    private static long COUPON_ISSUANCE_COUNT= 0;

    @Transactional
    public void save(CouponIssuanceDTO couponIssuanceDTO){
        ListOperations<String ,String> couponIssuanceCountBycoponIds = redisTemplate.opsForList();
        String stringCoponId = String.valueOf(COUPON_ID);

        long couponIssuanceCountById = count(COUPON_ID);

        if(Long.parseLong(Objects.requireNonNull(couponIssuanceCountBycoponIds.index(stringCoponId, 0))) < couponService.couponMaxCount(COUPON_ID)){
            couponIssuanceRepository.save(CouponIssuance.translate(couponIssuanceDTO));
            couponIssuanceCountBycoponIds.rightPush(stringCoponId, String.valueOf(COUPON_ISSUANCE_COUNT++));
        }
    }
@Transactional
    public long count(long couponId){
        return couponIssuanceRepository.countByCouponId(couponId);
    }

}
