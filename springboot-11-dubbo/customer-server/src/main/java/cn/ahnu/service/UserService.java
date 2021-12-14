package cn.ahnu.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

//模拟消费中心,消费者的服务类
@Service   //dubbo的service
public class UserService {
    @Reference
    TicketService ticketService;
//    模拟购买ticket
    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("customer-server=>ciTicketService=>byTicket:买到"+ticket);
    }

}

