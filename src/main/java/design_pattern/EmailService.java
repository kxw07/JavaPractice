package design_pattern;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {
        try {
            Thread.sleep(3_000);
            System.out.println("Use implements, send email to : " + event.getUsername());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
