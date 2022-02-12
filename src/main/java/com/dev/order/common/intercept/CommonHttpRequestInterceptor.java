package com.dev.order.common.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class CommonHttpRequestInterceptor implements HandlerInterceptor {
    public static final String HEADER_REQUEST_UUID_KEY = "x-request-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String requestEventId = request.getHeader(HEADER_REQUEST_UUID_KEY);
        System.out.printf("request_id", requestEventId);
        if (StringUtils.isEmpty(requestEventId)) {
            requestEventId = UUID.randomUUID().toString();
        }

        response.addHeader(HEADER_REQUEST_UUID_KEY, requestEventId);
        return true;
    }
}
