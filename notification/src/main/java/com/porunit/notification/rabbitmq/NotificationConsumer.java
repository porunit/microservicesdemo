package com.porunit.notification.rabbitmq;

import com.porunit.clients.notification.NotificationRequest;
import com.porunit.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;
    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest request){
      log.info("Consumed {} from queue", request);
      notificationService.send(request);
    }
}
