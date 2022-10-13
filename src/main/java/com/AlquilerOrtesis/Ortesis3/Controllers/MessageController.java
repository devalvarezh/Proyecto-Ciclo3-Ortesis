package com.AlquilerOrtesis.Ortesis3.Controllers;

import com.AlquilerOrtesis.Ortesis3.Model.Message;
import com.AlquilerOrtesis.Ortesis3.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @GetMapping("/{idMessage}")
    public Optional<Message> getMessage(@PathVariable("idMessage") int idMessage){
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@RequestBody Message message){
        return messageService.createMessage(message);
    }

    @PutMapping("/update")
    public Message updateMessage(@RequestBody Message message){
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/{idMessage}")
    public boolean deleteMessage(@PathVariable("idMessage") int id){
        return messageService.deleteMessage(id);
    }
}
