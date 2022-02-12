package com.dev.order.interfaces.partner;

import com.dev.order.application.partner.PartnerFacade;
import com.dev.order.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {

    private final PartnerFacade partnerFacade;

    @PostMapping("")
    public CommonResponse registerPartner (@RequestBody @Valid PartnerDto.RegisterRequest registerRequest) {
        var command = registerRequest.toCommand();
        var partnerInfo = partnerFacade.registerPartner(command);
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }

    @GetMapping("{partnerToken}")
    public CommonResponse getPartnerById (@PathVariable String partnerToken) {
        var partnerInfo = partnerFacade.getPartnerByPartnerToken(partnerToken);
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }
}
