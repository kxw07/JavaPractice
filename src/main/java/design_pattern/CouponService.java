package design_pattern;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @EventListener
    public void addCoupon(UserRegisterEvent event) {
        System.out.println("Use Spring Boot Annotation, send coupon to : " + event.getUsername());
    }
}
