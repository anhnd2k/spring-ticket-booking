package com.noa.ticketbook.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Aspect
@Component
@Slf4j
public class TransactionAspect {

    @Before("@annotation(getMapping)")
    public void startTransaction(GetMapping getMapping) {
        log.info("aaaaaaa get mapping before leeeeeeeeee");
    }

    @After("@annotation(getMapping)")
    public void afterGetMapping(GetMapping getMapping){
        log.info("aaaaaaa get mapping after leeeeeeeeee");
    }
}

