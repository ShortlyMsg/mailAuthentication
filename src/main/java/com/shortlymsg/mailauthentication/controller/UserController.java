package com.shortlymsg.mailauthentication.controller;

import com.shortlymsg.mailauthentication.dto.UserDto;
import com.shortlymsg.mailauthentication.entity.User2;
import com.shortlymsg.mailauthentication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<User2> saveUser(@RequestBody User2 user) {
        log.info("Inside saveUser method of UserController");
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        log.info("Inside getAll method of UserController");
        return ResponseEntity.ok(userService.getAll());
    }

/*    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<User2> getUserById(@PathVariable("id") String id) {
        log.info("Inside getUserById method of UserController");
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@RequestBody User2 user,
                                                  @PathVariable("id") String userId){
        log.info("Inside updateUserById method of UserController");
        return ResponseEntity.ok(userService.updateUserById(user, userId));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        log.info("Inside deleteUser method of UserController");
        userService.deleteUser(id);
    }
}
