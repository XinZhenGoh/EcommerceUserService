//package com.usermanagement.controller;
//
//import com.usermanagement.dto.Address;
//import com.usermanagement.dto.User;
//import com.usermanagement.service.S3Util;
//import com.usermanagement.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//	@Autowired
//	UserService userService;
//
//	@Autowired
//	S3Util util;
//
//	@PostMapping
//	public void addUser(@ModelAttribute User user) {
//		userService.addUser(user);
//	}
//
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping("/upload")
//	public ResponseEntity addImage(@RequestParam("imageFile") MultipartFile file,
//								   @RequestParam String username
//	) throws IOException {
//		String path = S3Util.uploadImageWithMultipart(file, file.getOriginalFilename());
//		User u  = new User(username,path);
//		userService.addUser(u);
//		return ResponseEntity.status(HttpStatus.OK).build();
//	}
//
//	@GetMapping("/{id}")
//	public User getUser(@RequestParam int id) {
//		return userService.getUser(id);
//	}
//
//	@PutMapping
//	public void updateUser(@RequestBody User user) {
//
//	}
//}
