package cn.ahnu.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("执行了Hello方法");
    }
}
