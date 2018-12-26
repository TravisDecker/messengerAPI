package com.straylense.messenger;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ExposesResourceFor(MessageEntity.class)
@RestController
@RequestMapping("/messages")
public class MessageController {

  private MessageRepository repository;

  public MessageController(MessageRepository repository) {
    this.repository = repository;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MessageEntity> Post(@RequestBody MessageEntity message) {
    repository.save(message);
    return ResponseEntity.created(message.getHref()).body(message);
  }

}
