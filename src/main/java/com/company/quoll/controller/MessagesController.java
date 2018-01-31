package com.company.quoll.controller;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import com.company.quoll.services.MessageService;
import com.company.quoll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class MessagesController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @GetMapping("/messages")
    public String getMessages(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = userService.findUserByUsername(currentUser.getUsername());

        List<Message> messages = messageService.findByRecipientOrSender(user);
        List<User> contacts = new ArrayList<>();
        for (Message m : messages) {
            final User sender = m.getSender();
            final User recipient = m.getRecipient();

            if (!contacts.contains(sender) && !sender.equals(user)) {
                contacts.add(sender);
            }

            if (!contacts.contains(recipient) && !recipient.equals(user)) {
                contacts.add(recipient);
            }
        }

        model.addAttribute("contacts", contacts);

        Map<String, Message> lastMessages = new HashMap<>();
        for (User u : contacts) {
            final List<Message> lastUserMessages = messageService.findLastForUsers(user, u);
            if (lastUserMessages.size() < 1) {
                continue;
            }

            lastMessages.put(u.getUsername(), lastUserMessages.get(0));
        }

        model.addAttribute("lastMessages", lastMessages);

        return "messages";
    }

    @RequestMapping("/messages/{contact_id}")
    public String getConversation(Model model, @AuthenticationPrincipal UserDetails currentUser, @PathVariable("contact_id") int contact_id){
        User user = userService.findUserByUsername(currentUser.getUsername());
        model.addAttribute("user", user);

        User contact = userService.findUserById(contact_id);
        model.addAttribute("contact", contact);

        List<Message> messages = messageService.findMessageByRecipientAndSender(contact, user);
        model.addAttribute("messages", messages);

        Message newMessage = new Message();
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
