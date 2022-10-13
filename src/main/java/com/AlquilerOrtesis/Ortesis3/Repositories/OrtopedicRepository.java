package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Ortopedic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrtopedicRepository {

    @Autowired
    private OrtopedicCRUDRepository ortopedicCRUDRepository;

    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) ortopedicCRUDRepository.findAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id){
        return ortopedicCRUDRepository.findById(id);
    }

    public Ortopedic save(Ortopedic ortopedic){
        return ortopedicCRUDRepository.save(ortopedic);
    }

    public void delete(Ortopedic ortopedic){
        ortopedicCRUDRepository.delete(ortopedic);
    }
}
