package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.Message;
import com.AlquilerOrtesis.Ortesis3.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message createMessage(Message message){
        if(message.getIdMessage() ==null){
            return messageRepository.save(message);
        } else {
            return message;
        }
    }

    public Message updateMessage(Message message){
        if(message.getIdMessage() !=null){
            Optional<Message> temp =messageRepository.getMessage(message.getIdMessage());
            if(temp.isPresent()){
                if(message.getMessageText()!=null)
                    temp.get().setMessageText(message.getMessageText());
                if(message.getClient()!=null)
                    temp.get().setClient(message.getClient());
                if(message.getOrtopedic()!=null)
                    temp.get().setOrtopedic(message.getOrtopedic());
                return messageRepository.save(temp.get());
            }else {
                return message;
            }
        } else {
            return message;
        }
    }

   public boolean deleteMessage(int idMessage){
        Boolean success = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return true;
   }

}
