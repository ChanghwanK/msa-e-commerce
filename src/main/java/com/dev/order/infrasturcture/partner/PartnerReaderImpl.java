package com.dev.order.infrasturcture.partner;

import com.dev.order.domain.partner.Partner;
import com.dev.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Component
public class PartnerReaderImpl implements PartnerReader {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(Long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
