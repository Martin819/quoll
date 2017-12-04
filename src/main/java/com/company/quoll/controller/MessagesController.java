package com.company.quoll.controller;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import com.company.quoll.services.MessageService;
import com.company.quoll.services.MessageServiceImpl;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MessagesController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @GetMapping("/messages")
    public String getMessages(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = userService.findUserByUsername(currentUser.getUsername());
        List<Message> messages = messageService.findLastMessages(user);
        model.addAttribute("messages", messages);
        return "messages";
    }

    @RequestMapping("/messages/{sender_id}")
    public String getConversation(Model model, @AuthenticationPrincipal UserDetails currentUser, @PathVariable("sender_id") int sender_id){
        User user = userService.findUserByUsername(currentUser.getUsername());
        User sender = userService.findUserById(sender_id);
        List<Message> messages = messageService.findMessageByRecipientAndSenderOrderByDateTimeDesc(user, sender);
        model.addAttribute("messages", messages);
        return "messages";
    }

}
