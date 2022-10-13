package com.AlquilerOrtesis.Ortesis3.Controllers;

import com.AlquilerOrtesis.Ortesis3.Model.Client;
import com.AlquilerOrtesis.Ortesis3.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable("idClient") int id){
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{idClient}")
    public boolean deleteClient(@PathVariable("idClient") int id){
        return clientService.deleteClient(id);
    }
}
