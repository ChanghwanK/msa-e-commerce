package com.dev.order.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
public class PartnerCommand {

    private final String partnerName;
    private final String businessNo;
    private final String email;


    public Partner toEntity() {
       return Partner.builder()
               .partnerName(partnerName)
               .businessNo(businessNo)
               .email(email)
               .build();
    }
}
