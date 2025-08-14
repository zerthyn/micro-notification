package org.rhydo.micronotification.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderEventConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleOrderEvent(Map<String, Object> orderEvent) {
        System.out.println("Received order event: " + orderEvent);

        Long orderId = (Long)orderEvent.get("orderId");
        String status = (String)orderEvent.get("status");
        System.out.println("Received order event with orderId: " + orderId + ", status: " + status);
    }
}
