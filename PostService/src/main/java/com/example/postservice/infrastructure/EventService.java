package com.example.postservice.infrastructure;

import com.example.postservice.dto.CommentInfo;
import com.example.postservice.dto.LikeInfo;
import com.example.postservice.models.Comment;
import com.example.postservice.models.Like;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void CommentCreated(Comment comment) {
        CommentInfo info = new CommentInfo(comment.getId(), comment.getContent(), "add");
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, info);
    }

    public void LikeCreated(Like like) {
        LikeInfo info = new LikeInfo(like.getId(), "add");
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE_LIKE, MessagingConfig.ROUTING_KEY_LIKE, info);
    }

}
