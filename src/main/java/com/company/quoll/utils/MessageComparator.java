package com.company.quoll.utils;

import com.company.quoll.model.Message;

import java.util.Comparator;

public abstract class MessageComparator implements Comparator<Message> {
    @Override
    public int compare(Message o1, Message o2) {
        return o1.getDateTime().compareTo(o2.getDateTime());
    }
}
