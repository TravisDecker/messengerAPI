package com.straylense.messenger;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, UUID> {

  List<MessageEntity> findAllByUserIdAndRecipientId(String userID, String recipientId);
}
