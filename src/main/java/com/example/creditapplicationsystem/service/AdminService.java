package com.example.creditapplicationsystem.service;

import com.example.creditapplicationsystem.exception.AdminNotFound;
import com.example.creditapplicationsystem.model.Admin;
import com.example.creditapplicationsystem.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public List<Admin> getAllAdmins(){
        List<Admin> allAdmins = adminRepo.findAll();
        return allAdmins;
    }

    public Admin getAdminByID(Long ID){
        Optional<Admin> admin = adminRepo.findById(ID);
        return admin.orElseThrow(()->new AdminNotFound("Admin with id:"+ID+" not found!"));
    }


    public Admin createAdmin(Admin admin){
            return adminRepo.save(admin);
        }


    public void deleteAdmin(Long id){
        getAdminByID(id);
        adminRepo.deleteById(id);
    }

    public Admin updateAdmin(Long id, Admin admin){

        Admin existingAdmin = getAdminByID(id);
        existingAdmin.setName(admin.getName());
        existingAdmin.setSurname(admin.getSurname());

        return adminRepo.save(existingAdmin);
    }




}
