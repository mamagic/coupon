package com.project.coupon;


import com.project.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
public class TestCouponController {

    @Autowired
    CouponService couponService;

    @Test
    public void test(){
        couponService.couponMaxCount(1L);
        List<Thread> workers = IntStream.range(0, 200)
                .mapToObj(index -> {
                    return new Thread(new IssuanceTest(index));
                })
                .toList();

        workers.forEach(Thread::start);
    }

    private class IssuanceTest implements Runnable {
        private int index;

        public IssuanceTest(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println(index);
        }
    }

}
