package com.example.case6be.controllers;

import com.example.case6be.models.AppUser;
import com.example.case6be.models.Role;
import com.example.case6be.models.Wallet;
import com.example.case6be.models.dto.UserToken;
import com.example.case6be.services.AppUserService;
import com.example.case6be.services.IWalletService;
import com.example.case6be.services.JwtService;

import com.example.case6be.services.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    SendMailService sendMailService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    AppUserService appUserService;


    @PostMapping("/login")
    public UserToken login(@RequestBody AppUser appUser){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            AppUser appUser1 = appUserService.findByUserName(appUser.getUsername());
            return new UserToken(appUser1.getId(),appUser1.getUsername(),token,appUser1.getRoles());
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
//        sendMailService.sendMail(appUser);
       return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
    }

    @PostMapping("/checkuser")
    public AppUser check(@RequestBody String user){
        return appUserService.findByUserName(user);
    }
    @PostMapping("/checkemail")
    public ResponseEntity<AppUser> checkemail(@RequestBody String email){
        System.out.printf("email" + appUserService.findByemail(email) );

        return new ResponseEntity<>(appUserService.findByemail(email), HttpStatus.OK);
    }



}
