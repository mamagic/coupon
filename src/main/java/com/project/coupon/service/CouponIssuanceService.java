package com.project.coupon.service;

import com.project.coupon.dto.CouponDTO;
import com.project.coupon.dto.CouponIssuanceDTO;
import com.project.coupon.entity.Coupon;
import com.project.coupon.entity.CouponIssuance;
import com.project.coupon.repository.CouponIssuanceRepository;
import com.project.coupon.repository.CouponRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponIssuanceService {

    private final CouponIssuanceRepository couponIssuanceRepository;
    @Transactional
    public void save(CouponIssuanceDTO couponIssuanceDTO){

        int couponIssuanceCountById = couponIssuanceRepository.findByCouponId(1L).size();


        if(couponIssuanceCountById > 100){
            return;
        }
        System.out.println(couponIssuanceDTO.getUserId() + " 입력");
        couponIssuanceRepository.save(CouponIssuance.translate(couponIssuanceDTO));
    }

    @Transactional
    public long count(){
        return couponIssuanceRepository.count();
    }

}
