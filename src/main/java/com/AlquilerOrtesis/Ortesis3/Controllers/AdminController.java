package com.AlquilerOrtesis.Ortesis3.Controllers;

import com.AlquilerOrtesis.Ortesis3.Model.Admin;
import com.AlquilerOrtesis.Ortesis3.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @GetMapping("/{idAdmin}")
    public Optional<Admin> getAdmin(@PathVariable("idAdmin") int idAdmin){
        return adminService.getAdmin(idAdmin);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{idAdmin}")
    public boolean deleteAdmin(@PathVariable("idAdmin") int idAdmin){
        return adminService.deleteAdmin(idAdmin);
    }
}
