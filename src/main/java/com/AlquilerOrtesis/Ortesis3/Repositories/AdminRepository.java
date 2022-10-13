package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Admin;
import com.AlquilerOrtesis.Ortesis3.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCRUDRepository adminCRUDRepository;

    public List<Admin> getAll(){
        return(List<Admin>) adminCRUDRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminCRUDRepository.findById(id);
    }

    public Admin save(Admin admin) {
        return adminCRUDRepository.save(admin);
    }

    public void delete(Admin admin){
        adminCRUDRepository.delete(admin);
    }
}
