package com.company.quoll.utils;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.collections4.CollectionUtils;

public class MessagesUtils {
    public static List<User> getUniqueContacts(List<Message> messagesFrom, List<Message> messagesTo) {
        List<User> uniqueContacts = new ArrayList<>();
        List<User> contactsFrom = new ArrayList<>();
        List<User> contactsTo = new ArrayList<>();
        List<User> allContacts = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(messagesFrom) && CollectionUtils.isNotEmpty(messagesTo)) {
            for (Message message:messagesFrom) {
                System.out.println(message.getContent());
                contactsFrom.add(message.getSender());
            }
            for (Message message:messagesTo) {
                contactsTo.add(message.getRecipient());
            }
            Stream.of(contactsFrom, contactsTo).forEach(allContacts::addAll);
            uniqueContacts = allContacts.stream().distinct().collect(Collectors.toList());
        } else if (CollectionUtils.isEmpty(messagesFrom) && CollectionUtils.isEmpty(messagesTo)) {
            return uniqueContacts;
        } else if (CollectionUtils.isEmpty(messagesFrom)) {
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
        if (CollectionUtils.isNotEmpty(messagesFrom) && CollectionUtils.isNotEmpty(messagesTo)) {
            Stream.of(messagesFrom, messagesTo).forEach(allMessages::addAll);
        } else if (CollectionUtils.isEmpty(messagesFrom) && CollectionUtils.isEmpty(messagesTo)) {
            return allMessages;
        } else if (CollectionUtils.isEmpty(messagesFrom)) {
            allMessages = messagesTo;
        } else {
            allMessages = messagesFrom;
        }
        return allMessages;
    }
}
