package com.kamikadze328.testforcv.test2.controller;

import com.kamikadze328.testforcv.test2.model.User;
import com.kamikadze328.testforcv.test2.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.regex.Pattern;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@CrossOrigin
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        Pattern pattern = Pattern.compile("[" + "а-яА-ЯёЁ" + "\\p{Punct}" + "]" + "*");
        if (pattern.matcher(newUser.getUsername()).matches())
            return new ResponseEntity<>("Unacceptable symbols", HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        else {

            return (userService.findByUsername(newUser.getUsername()) != null)
                    ? new ResponseEntity<>("User with username " + newUser.getUsername() + "already exist ", HttpStatus.CONFLICT)
                    : new ResponseEntity<>("User's id: " + userService.save(newUser).getId(), HttpStatus.CREATED);
        }
    }

    //@CrossOrigin
    @RequestMapping("/login")
    public ResponseEntity<String> user(Principal principal) {
        String name;
        if (principal != null) {
            name = principal.getName();
        } else {
            return new ResponseEntity<>("Wrong username or password", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}
