package com.example.creditapplicationsystem.controller;

import com.example.creditapplicationsystem.model.Admin;
import com.example.creditapplicationsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public ResponseEntity getAllAdmins(){
        List<Admin> allAdmins = adminService.getAllAdmins();
        return ResponseEntity.ok(allAdmins);
    }
    @GetMapping("/admin/{ID}")
    public ResponseEntity getAdminByID(@PathVariable(name = "ID") Long id){
        Optional<Admin> AdminByID = adminService.getAdminByID(id);
        return ResponseEntity.ok(AdminByID.get());
    }
    @PostMapping("/admin")
    public ResponseEntity createAdmin(@RequestBody Admin admin){
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdmin);
    }
    @DeleteMapping("/admin/{ID}")
    public ResponseEntity deleteAdminById(@PathVariable(name = "ID") Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.ok("Admin Deleted");
    }
    @PutMapping("/admin/{ID}")
    public ResponseEntity updateAdminById(@PathVariable(name = "ID") Long id, @RequestBody Admin admin){
        Admin updatedAdmin = adminService.updateAdmin(id, admin);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAdmin);
    }

}
