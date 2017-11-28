package com.company.quoll.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long id;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "sender")
    private User sender;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "recipient")
    private User recipient;

    @NotBlank
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateTime", insertable=false, updatable=false)
    private Date dateTime;

    @NotEmpty
    @Column(name = "content")
    @Lob
    private byte[] content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
