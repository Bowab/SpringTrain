package com.main.profiletower.repository;

import com.main.profiletower.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
