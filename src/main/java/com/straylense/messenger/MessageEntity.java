package com.straylense.messenger;

import java.net.URI;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

@Entity
@Component
public class MessageEntity {

  private static EntityLinks entityLinks;
  private String userId;
  private String recipientId;
  private Date dateTime;
  private String message;
  private UUID messageId;

  @PostConstruct
  private void initEntityLinks() {
    String ignore = entityLinks.toString();
  }

  public static void setEntityLinks(EntityLinks entityLinks) {
    MessageEntity.entityLinks = entityLinks;
  }

  public UUID getMessageId() {
    return messageId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(String recipientId) {
    this.recipientId = recipientId;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setMessageId(UUID messageId) {
    this.messageId = messageId;
  }

  public URI getHref() {
    return entityLinks.linkForSingleResource(MessageEntity.class, messageId).toUri();
  }
}
