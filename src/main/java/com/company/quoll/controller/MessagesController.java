package com.company.quoll.controller;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import com.company.quoll.services.MessageService;
import com.company.quoll.services.MessageServiceImpl;
import com.company.quoll.services.UserService;
import com.company.quoll.utils.MessagesUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class MessagesController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

/*    @GetMapping("/messages")
    public String getMessages(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = userService.findUserByUsername(currentUser.getUsername());
        List<Message> messages = messageService.findLastMessages(user);
        model.addAttribute("messages", messages);
        return "messages";
    }*/

    @GetMapping("/messages")
    public String getMessages(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = userService.findUserByUsername(currentUser.getUsername());
        List<Message> messagesFrom = messageService.findMessageByRecipient(user);
        List<Message> messagesTo = messageService.findMessageBySender(user);
        List<Message> allMessages = MessagesUtils.getAllMessages(messagesFrom, messagesTo);
        List<User> uniqueContacts = MessagesUtils.getUniqueContacts(messagesFrom, messagesTo);
        model.addAttribute("messagesFrom", messagesFrom);
        model.addAttribute("messagesTo", messagesTo);
        model.addAttribute("allMessages", allMessages);
        model.addAttribute("uniqueContacts", uniqueContacts);
        return "messages";
    }

    @RequestMapping("/messages/{contact_id}")
    public String getConversation(Model model, @AuthenticationPrincipal UserDetails currentUser, @PathVariable("contact_id") int contact_id){
        User user = userService.findUserByUsername(currentUser.getUsername());
        User contact = userService.findUserById(contact_id);
        List<Message> messagesTo = messageService.findMessageByRecipientAndSenderOrderByDateTimeDesc(user, contact);
        List<Message> messagesFrom = messageService.findMessageByRecipientAndSenderOrderByDateTimeDesc(contact, user);
        List<Message> allMessages = MessagesUtils.getAllMessages(messagesFrom, messagesTo);
        allMessages.sort(Comparator.comparing(Message::getDateTime));
        for (Message message:allMessages) {
            message.setMessageRead(true);
            messageService.saveMessage(message);
        }
        Message newMessage = new Message();
        model.addAttribute("allMessages", allMessages);
        model.addAttribute("user", user);
        model.addAttribute("contact", contact);
        model.addAttribute("newMessage", newMessage);
        return "conversation";
    }

    @PostMapping("/messages/{contact_id}")
    public String submitForm(Message newMessage, @AuthenticationPrincipal UserDetails currentUser, @PathVariable("contact_id") int contact_id) {
        User user = userService.findUserByUsername(currentUser.getUsername());
        User contact = userService.findUserById(contact_id);
        newMessage.setSender(user);
        newMessage.setRecipient(contact);
        System.out.println("Sender: " + newMessage.getSender().getUsername());
        System.out.println("Recipient: " + newMessage.getRecipient().getUsername());
        System.out.println("Content: " + newMessage.getContent());
        newMessage.setMessageRead(true);
        messageService.saveMessage(newMessage);
        return "redirect:/messages/{contact_id}";

    }
}
