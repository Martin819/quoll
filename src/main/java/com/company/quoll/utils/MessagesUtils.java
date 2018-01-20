package com.company.quoll.utils;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessagesUtils {
    public static List<User> getUniqueContacts(List<Message> messagesFrom, List<Message> messagesTo) {
        List<User> uniqueContacts = new ArrayList<>();
        List<User> contactsFrom = null;
        List<User> contactsTo = null;
        List<User> allContacts = new ArrayList<>();
        if (!messagesFrom.isEmpty() && !messagesTo.isEmpty()) {
            for (Message message:messagesFrom) {
                contactsFrom.add(message.getSender());
            }
            for (Message message:messagesTo) {
                contactsTo.add(message.getRecipient());
            }
            Stream.of(contactsFrom, contactsTo).forEach(allContacts::addAll);
            uniqueContacts = allContacts.stream().distinct().collect(Collectors.toList());
        } else if (messagesFrom.isEmpty() && messagesTo.isEmpty()) {
            return uniqueContacts;
        } else if (messagesFrom.isEmpty()) {
            for (Message message:messagesTo) {
                contactsTo.add(message.getRecipient());
            }
            uniqueContacts = contactsTo;
        } else {
            for (Message message:messagesFrom) {
                contactsFrom.add(message.getSender());
            }
            uniqueContacts = contactsFrom;
        }
        return uniqueContacts;
    }

    public static List<Message> getAllMessages(List<Message> messagesFrom, List<Message> messagesTo){
        List<Message> allMessages = new ArrayList<>();
        if (!messagesFrom.isEmpty() && !messagesTo.isEmpty()) {
            Stream.of(messagesFrom, messagesTo).forEach(allMessages::addAll);
        } else if (messagesFrom.isEmpty() && messagesTo.isEmpty()) {
            return allMessages;
        } else if (messagesFrom.isEmpty()) {
            allMessages = messagesTo;
        } else {
            allMessages = messagesFrom;
        }
        return allMessages;
    }
}
