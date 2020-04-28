package com.d7kj.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TenSecondTask {
    @Scheduled(fixedRate = 10000)
    public void execute(){
        log.info("TenSecondTask.execute()");
    }
}
