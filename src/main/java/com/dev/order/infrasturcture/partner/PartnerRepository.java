package com.dev.order.infrasturcture.partner;

import com.dev.order.domain.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Optional<Partner> findByPartnerToken(String partnerToken);
    Optional<Partner> findByEmail(String email);
}