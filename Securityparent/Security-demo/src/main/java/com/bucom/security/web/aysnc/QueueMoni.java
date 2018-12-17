package com.bucom.security.web.aysnc;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Data
public class QueueMoni {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //下订单消息
    private String placeOrder;
    //订单完成消息
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() -> {
            logger.info("接到下单请求, " + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕," + placeOrder);
        }).start();
    }

    public String getComleteOrder() {
        return completeOrder;
    }

    public void setComleteOrder(String comleteOrder) {
        this.completeOrder = comleteOrder;
    }
}
