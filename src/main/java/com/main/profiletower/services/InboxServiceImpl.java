package com.main.profiletower.services;

import com.main.profiletower.models.Inbox;
import com.main.profiletower.repository.InboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;




@Service("inboxService")
public class InboxServiceImpl implements InboxService {

    @Autowired
    private InboxRepository inboxRepository;


}
