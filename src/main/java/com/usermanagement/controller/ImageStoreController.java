package com.usermanagement.controller;

import com.usermanagement.service.S3Util;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class ImageStoreController {

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity addImage(@RequestParam("imageFile") MultipartFile file, @RequestParam String username) throws IOException {
        String path = S3Util.uploadImageWithMultipart(file, file.getOriginalFilename());
//		User u  = new User(username,path);
//		userService.addUser(u);
        System.out.println(path);
        return ResponseEntity.ok("Image uploaded");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/test")
    public ResponseEntity testMethod(){
        return ResponseEntity.ok("test method ok");
    }
}
