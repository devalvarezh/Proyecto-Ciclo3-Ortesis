package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.Admin;
import com.AlquilerOrtesis.Ortesis3.Repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin createAdmin(Admin admin){
        if(admin.getIdAdmin() ==null){
            return adminRepository.save(admin);
        } else {
            return admin;
        }
    }

    public Admin updateAdmin(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> temp =adminRepository.getAdmin(admin.getIdAdmin());
            if(temp.isPresent()){
                if(admin.getName()!=null)
                    temp.get().setName(admin.getName());
                if(admin.getEmail()!=null)
                    temp.get().setEmail(admin.getEmail());
                if (admin.getPassword()!=null)
                    temp.get().setPassword(admin.getPassword());
                return adminRepository.save(temp.get());
            }else {
                return admin;
            }
        } else {
            return admin;
        }
    }

    public boolean deleteAdmin(int idAdmin){
        Boolean success = getAdmin(idAdmin).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return true;
    }

}
