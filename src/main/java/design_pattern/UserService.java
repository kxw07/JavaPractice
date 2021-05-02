package design_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableAsync
@Service
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username) {
        System.out.println("Register user : " + username);
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));
    }

    public static void main(String[] args) {
        SpringApplication.run(UserService.class, args);
    }
}
