package com.neosoft.controller;
import com.neosoft.model.JwtResponse;
import com.neosoft.model.User;
import com.neosoft.model.UserDtls;
import com.neosoft.service.UserDtlsService;
import com.neosoft.service.UserServiceImpl;
import com.neosoft.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j

public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserDtlsService userDtlsService;
    @Autowired
    JWTUtil jwtUtil;
    @Autowired
    AuthenticationManager authenticationManager;


    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody User user) throws Exception {
     System.out.println(user);
     try
     {
         this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
     }catch (UsernameNotFoundException e){
         e.printStackTrace();
         throw new Exception("Bad Credentials");
     }
        UserDetails userDetails = this.userDtlsService.loadUserByUsername(user.getUserName());
       String token = this.jwtUtil.generateToken(user.getUserName());
       System.out.println("JWT"+token);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    @PostMapping("/singup")
    public String registerForm(@RequestBody UserDtls userDtls)
    {
        userService.saveData(userDtls);
        return "Data save Successfully";
    }

    @GetMapping("/getalluserdata")
    public ResponseEntity<List<User>> getAllData()
    {
        return ResponseEntity.ok(userService.getAllData());
    }

    @RequestMapping("/search")
    public List<UserDtls>  search(User user, @Param("query") String query) {
        List<UserDtls> listUsers = userService.listAll(query);
        return listUsers;
    }

}
