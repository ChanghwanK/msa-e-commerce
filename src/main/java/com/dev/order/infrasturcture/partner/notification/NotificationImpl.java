package com.dev.order.infrasturcture.partner.notification;

import com.dev.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationImpl implements NotificationService {

    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("send email to partner");
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("send kakao to partner");
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("send sms to partner");
    }
}
