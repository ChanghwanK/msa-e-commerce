package com.dev.order.infrasturcture.partner;

import com.dev.order.common.exception.InvalidParamException;
import com.dev.order.common.response.ErrorCode;
import com.dev.order.domain.partner.Partner;
import com.dev.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PartnerStoreImpl implements PartnerStore {

    private final PartnerRepository partnerRepository;
    @Override
    public Partner store(Partner initPartner) {
        validationCheck(initPartner);
        emailDuplicationCheck(initPartner.getEmail());
        return partnerRepository.save(initPartner);
    }

    private void emailDuplicationCheck(String email) {
       var partner = partnerRepository.findByEmail(email);
       if (partner.isPresent()) throw new InvalidParamException("Duplicated Email", ErrorCode.COMMON_INVALID_PARAMETER);
    }

    private void validationCheck(Partner partner) {
        if (StringUtils.isEmpty(partner.getPartnerToken())) throw new InvalidParamException("partner.getPartnerToken()");
        if (StringUtils.isEmpty(partner.getPartnerName())) throw new InvalidParamException("partner.getPartnerName()");
        if (StringUtils.isEmpty(partner.getBusinessNo())) throw new InvalidParamException("partner.getBusinessNo()");
        if (StringUtils.isEmpty(partner.getEmail())) throw new InvalidParamException("partner.getEmail()");
        if (partner.getStatus() == null) throw new InvalidParamException("partner.getStatus()");
    }


}
