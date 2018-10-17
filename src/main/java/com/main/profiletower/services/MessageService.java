package com.main.profiletower.services;

import com.main.profiletower.models.Inbox;
import com.main.profiletower.models.InboxRow;
import com.main.profiletower.models.Message;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;




public interface MessageService {
    public List<Message> findUsersMessages(long userId);
    public Inbox findInboxByUserId(long userId);
    public List<InboxRow> findInboxRows(long userId);
    public List<Message> findCorrectMessages(List<InboxRow> ibrList);
}
