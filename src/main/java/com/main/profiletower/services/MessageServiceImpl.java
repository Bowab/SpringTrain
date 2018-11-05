package com.main.profiletower.services;

import com.main.profiletower.models.Inbox;
import com.main.profiletower.models.InboxRow;
import com.main.profiletower.models.Message;
import com.main.profiletower.models.User;
import com.main.profiletower.repository.InboxRepository;
import com.main.profiletower.repository.InboxRowRepository;
import com.main.profiletower.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private InboxRepository inboxRepository;

    @Autowired
    private InboxRowRepository inboxRowRepository;


    @Override
    public List<Message> findUsersMessages(long userId) {

        //1. Find the right inbox
        Inbox thisInbox = findInboxByUserId(userId);

        //2. Find all inbox_rows associated with that inbox
        List<InboxRow> inboxRowList = findInboxRows(thisInbox.getId());

        //3. Find all messages involved with the inboxRows
        List<Message> doneMessage = findCorrectMessages(inboxRowList);

        //Return doneMessage?
        return doneMessage;
    }


    //To find inbox that belongs to the right user
    @Override
    public Inbox findInboxByUserId(long userId) {


        Inbox retInbox = new Inbox();
        Iterable<Inbox> inboxList = inboxRepository.findAll();

        for(Inbox row : inboxList ){
            if(row.getUser().getId() == userId)
            {
                retInbox = row;
                break;
            }
        }

        return retInbox;
    }

    //To find inboxrows
    @Override
    public List<InboxRow> findInboxRows(long inboxId){

        Iterable<InboxRow> ibrList = inboxRowRepository.findAll();

        List<InboxRow> ibrListDone = new ArrayList<>();

        for(InboxRow row : ibrList){
             if(row.getInbox().getId() == inboxId){
                 ibrListDone.add(row);
            }
        }

        return ibrListDone;
    }


    //Finally find all the correct messages
    @Override
    public List<Message> findCorrectMessages(List<InboxRow> ibrList){

        List<Message> allMesseges = new ArrayList<Message>();

        for(InboxRow row : ibrList ){
            allMesseges.add(row.getMessage());
        }


        return allMesseges;
    }


}
