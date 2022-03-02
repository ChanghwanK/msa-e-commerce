package com.dev.order.domain.partner;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartnerByToken(String partnerToken);
}
