package com.company.quoll.repository;

import com.company.quoll.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByRecipient(int recipient);
    List<Message> findByRecipientAndSender(int recipient, int sender);
    List<Message> findByRecipientAndDateTimeAfter(int recipient, Date dateTime);
    List<Message> findByRecipientAndSenderAndDateTimeAfter(int recipient, int sender, Date dateTime);
    Message findById(long id);

}
