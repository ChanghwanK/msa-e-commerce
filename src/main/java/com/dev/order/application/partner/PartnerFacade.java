package com.dev.order.application.partner;

import com.dev.order.domain.notification.NotificationService;
import com.dev.order.domain.partner.PartnerCommand;
import com.dev.order.domain.partner.PartnerInfo;
import com.dev.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PartnerFacade {

    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
        var partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(
                command.getEmail(),
                "안녕하세요 Blue ECommerce 입니다.",
                "고객님의 입점을 환영 합니다."
        );
        return partnerInfo;
    }

    public PartnerInfo getPartnerByPartnerToken(String partnerToken) {
        // 파트너 정보
        // 주문 건수
        // 상품 정보 등등
        return partnerService.getPartnerInfo(partnerToken);
    }
}
