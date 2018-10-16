package com.main.profiletower.repository;

import com.main.profiletower.models.Inbox;
import com.main.profiletower.models.User;
import org.springframework.data.repository.CrudRepository;

public interface InboxRepository extends CrudRepository<Inbox, Long> {

}
