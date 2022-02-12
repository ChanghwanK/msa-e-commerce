package com.dev.order.domain.partner;

import com.dev.order.common.utils.TokenGenerator;
import com.dev.order.domain.BaseTimeEntity;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "partners")
public class Partner extends BaseTimeEntity {
    private static final String PREFIX_PARTNER = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
       ENABLE ("활성화"),
       DISABLE ("비활성화");

       private final String description;
    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {
        if (StringUtils.isEmpty(partnerName)) throw new NullPointerException();
        if (StringUtils.isEmpty(businessNo)) throw new NullPointerException();
        if (StringUtils.isEmpty(email)) throw new NullPointerException();

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }
}
