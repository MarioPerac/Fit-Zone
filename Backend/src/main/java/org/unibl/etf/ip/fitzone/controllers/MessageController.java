package org.unibl.etf.ip.fitzone.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.models.dto.Chat;
import org.unibl.etf.ip.fitzone.models.dto.Message;
import org.unibl.etf.ip.fitzone.models.requests.MessageRequest;
import org.unibl.etf.ip.fitzone.services.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController extends CrudController<Integer, MessageRequest, Message> {

    private MessageService messageService;
    public MessageController(MessageService crudService) {
        super(crudService, Message.class);

        this.messageService = crudService;
    }

    @GetMapping("/chats/{username}")
    public List<Chat> getAllFriendsNames(@PathVariable String username){

    return messageService.getAllFriendsName(username);
    }

    @GetMapping("/{username}/with/{friend}")
    public List<Message> getAllMessagesWithFriend(@PathVariable String username, @PathVariable String friend)
    {
        return messageService.getAllMessagesWithFriend(username, friend);
    }
}
