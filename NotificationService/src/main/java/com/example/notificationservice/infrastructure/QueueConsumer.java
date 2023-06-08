package com.example.notificationservice.infrastructure;


import com.example.notificationservice.dto.CommentInfo;
import com.example.notificationservice.dto.LikeInfo;
import com.example.notificationservice.infrastructure.MessagingConfig;
import com.example.notificationservice.models.Notification;
import com.example.notificationservice.models.NotificationType;
import com.example.notificationservice.services.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class QueueConsumer {

    @Autowired
    NotificationService notificationService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void receiveComment(CommentInfo commentInfo){
        if (commentInfo.getMessage().equals("add")) {
            try {
                NotificationType notificationType = notificationService.GetNotificationType("COMMENTED");
                Notification notification = new Notification();
                notification.setOpen(false);
                notification.setContent("User? Commented on your Post.");
                notification.setActionUserId(2);
                notification.setUserId(1);
                notification.setLikedComment(commentInfo.getId().intValue());
                notification.setNotificationType(notificationType);

                notificationService.Create(notification);

            }
            catch (Exception e) {
                System.out.println("Greska u dodavanju notifikacije!");
                System.out.println(e.getMessage());

                CommentInfo info = new CommentInfo(commentInfo.getId(), commentInfo.getContent(), "delete");
                rabbitTemplate.convertAndSend(MessagingConfig.REVERSE_EXCHANGE, MessagingConfig.REVERSE_ROUTING_KEY, info);
            }
        }
    }

    @RabbitListener(queues = MessagingConfig.QUEUE_LIKE)
    public void receiveLike(LikeInfo likeInfo){
        if (likeInfo.getMessage().equals("add")) {
            try {
                NotificationType notificationType = notificationService.GetNotificationType("LIKED");
                Notification notification = new Notification();
                notification.setOpen(false);
                notification.setContent("User? Liked your Comment.");
                notification.setActionUserId(2);
                notification.setUserId(1);
                notification.setLikedComment(likeInfo.getId().intValue());
                notification.setNotificationType(notificationType);

                notificationService.Create(notification);

            }
            catch (Exception e) {
                System.out.println("Greska u dodavanju notifikacije!");
                System.out.println(e.getMessage());

                LikeInfo info = new LikeInfo(likeInfo.getId(), "delete");
                rabbitTemplate.convertAndSend(MessagingConfig.REVERSE_EXCHANGE_LIKE, MessagingConfig.REVERSE_ROUTING_KEY_LIKE, info);
            }
        }
    }

}