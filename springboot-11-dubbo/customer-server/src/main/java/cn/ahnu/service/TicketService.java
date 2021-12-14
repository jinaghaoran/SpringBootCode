package cn.ahnu.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

public interface TicketService {
//    模拟服务提供者，后面会有消费者接口类获取Ticket
    String getTicket();
}
