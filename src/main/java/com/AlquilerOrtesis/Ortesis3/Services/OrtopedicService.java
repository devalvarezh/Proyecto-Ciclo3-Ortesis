package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.Ortopedic;
import com.AlquilerOrtesis.Ortesis3.Repositories.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtopedicService {

    @Autowired
    private OrtopedicRepository ortopedicRepository;

    public List<Ortopedic> getAll(){
        return ortopedicRepository.getAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicRepository.getOrtopedic(id);
    }

    public Ortopedic createOrtopedic(Ortopedic ortopedic){
        if(ortopedic.getId() ==null){
            return ortopedicRepository.save(ortopedic);
        }else {
            return ortopedic;
        }
    }

    public Ortopedic updateOrtopedic(Ortopedic ortopedic){
        if (ortopedic.getId()!=null){
            Optional<Ortopedic> temp = ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(temp.isPresent()){
                if(ortopedic.getName()!=null)
                    temp.get().setName(ortopedic.getName());
                if(ortopedic.getBrand()!=null)
                    temp.get().setBrand(ortopedic.getBrand());
                if(ortopedic.getDescription()!=null)
                    temp.get().setDescription(ortopedic.getDescription());
                if(ortopedic.getYear()!=null)
                    temp.get().setYear(ortopedic.getYear());
                if(ortopedic.getCategory()!=null)
                    temp.get().setCategory(ortopedic.getCategory());
                if(ortopedic.getMessages()!=null)
                    temp.get().setMessages(ortopedic.getMessages());
                if(ortopedic.getReservations()!=null)
                    temp.get().setReservations(ortopedic.getReservations());
                return ortopedicRepository.save(temp.get());
            }else {
                return ortopedic;
            }
        }else {
            return ortopedic;
        }
    }

    public boolean deleteOrtopedic(int id){
        Boolean success = getOrtopedic(id).map(ortopedic -> {
            ortopedicRepository.delete(ortopedic);
            return true;
        }).orElse(false);
        return true;
    }
}
