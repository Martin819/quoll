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
    List<Message> findBySender(User sender);
    List<Message> findByRecipientOrderByMessageReadAsc(User recipient);

    @Query("select m from Message m where (m.recipient=?1 and m.sender=?2) or (m.recipient=?2 and m.sender=?1) order by m.dateTime")
    List<Message> findByRecipientAndSender(User recipient, User sender);

    List<Message> findByRecipientAndSenderOrderByDateTimeDesc(User recipient, User sender);
    List<Message> findByRecipientAndDateTimeAfter(User recipient, Date dateTime);
    List<Message> findByRecipientAndSenderAndDateTimeAfter(User recipient, User sender, Date dateTime);
    List<Message> findDistinctByRecipientOrderByMessageReadAsc(User recipient);
    List<Message> findByRecipientAndMessageRead(User recipient, boolean messageRead);
    Message findById(long id);

    @Query("select m from Message m where (m.recipient=?1 or m.sender=?1) and m.dateTime=(select max(me.dateTime) from Message me where (m.recipient=?1 or m.sender=?1))")
    List<Message> findLastFor(User user);

    @Query("select m from Message m where m.recipient=?1 or m.sender=?1 order by m.dateTime desc")
    List<Message> findByRecipientOrSender(User u);

    @Query("select m from Message m where ((m.sender=?1 and m.recipient=?2) or (m.sender=?2 and m.recipient=?1)) and m.dateTime=(select max(me.dateTime) from Message me where (me.sender=?1 and me.recipient=?2) or (me.sender=?2 and me.recipient=?1))")
    List<Message> findLastForUsers(User u1, User u2);

}
