package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCRUDRepository clientCRUDRepository;

    public List<Client> getAll(){
        return(List<Client>) clientCRUDRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCRUDRepository.findById(id);
    }

    public Client save(Client client) {
        return clientCRUDRepository.save(client);
    }

    public void delete(Client client){
        clientCRUDRepository.delete(client);
    }
}
