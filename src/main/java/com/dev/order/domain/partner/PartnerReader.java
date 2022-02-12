package com.dev.order.domain.partner;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartner(String partnerToken);
}
