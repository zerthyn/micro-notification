package org.rhydo.micronotification.consumers;

import org.rhydo.micronotification.dtos.OrderCreatedEvent;
import org.rhydo.micronotification.dtos.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleOrderEvent(OrderCreatedEvent orderEvent) {
        System.out.println("Received order event: " + orderEvent);

        Long orderId = orderEvent.getOrderId();
        OrderStatus status = orderEvent.getStatus();
        System.out.println("Received order event with orderId: " + orderId + ", status: " + status);

        // Update Database
        // Send Notification
        // Send Emails
        // Generate Invoice
        // Send Seller Notification
    }
}
