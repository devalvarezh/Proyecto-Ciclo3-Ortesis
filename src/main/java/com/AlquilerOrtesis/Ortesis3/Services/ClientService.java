package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.Category;
import com.AlquilerOrtesis.Ortesis3.Model.Client;
import com.AlquilerOrtesis.Ortesis3.Repositories.CategoryRepository;
import com.AlquilerOrtesis.Ortesis3.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client createClient(Client client){
        if(client.getIdClient() ==null){
            return clientRepository.save(client);
        } else {
            return client;
        }
    }

    public Client updateClient(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> temp =clientRepository.getClient(client.getIdClient());
            if(temp.isPresent()){
                if(client.getEmail()!=null)
                    temp.get().setEmail(client.getEmail());
                if(client.getPassword()!=null)
                    temp.get().setPassword(client.getPassword());
                if(client.getName()!=null)
                    temp.get().setName(client.getName());
                if(client.getAge()!=null)
                    temp.get().setAge(client.getAge());
                if(client.getMessages()!=null)
                    temp.get().setMessages(client.getMessages());
                if(client.getReservations()!=null)
                    temp.get().setReservations(client.getReservations());
                return clientRepository.save(temp.get());
            }else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int idClient){
        Boolean success = getClient(idClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return true;
    }

}
