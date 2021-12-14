package cn.ahnu.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service    //dubbo下的Service注解
@Component   //dubbo整合后，推荐使用component注解
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "TestTicket=>获取了provider-server下的TicketService";
    }


}
