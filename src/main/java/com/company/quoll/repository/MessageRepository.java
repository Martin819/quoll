package com.company.quoll.repository;

import com.company.quoll.model.Message;
import com.company.quoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByRecipient(User recipient);
    List<Message> findByRecipientOrderByMessageReadAsc(User recipient);
    List<Message> findByRecipientAndSender(User recipient, User sender);
    List<Message> findByRecipientAndDateTimeAfter(User recipient, Date dateTime);
    List<Message> findByRecipientAndSenderAndDateTimeAfter(User recipient, User sender, Date dateTime);
    List<Message> findDistinctByRecipientOrderByMessageReadAsc(User recipient);
    Message findById(long id);

    @Query("select m from Message m where m.dateTime=(select max(me.dateTime) from Message me where me.sender=m.sender and me.recipient=?1)")
    List<Message> findLastForRecipient(User recipient);

}
