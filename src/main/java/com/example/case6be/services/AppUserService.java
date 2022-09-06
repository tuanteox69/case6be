package com.example.case6be.services;

import com.example.case6be.models.AppUser;
import com.example.case6be.repositorys.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUsername(username);
        return new User(appUser.getUsername(), appUser.getPassword(), appUser.getRoles());
    }

    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
        AppUser appUser = iAppUserRepo.findByUsername(username);
        return appUser;
    }
    public AppUser findByemail(String mail){
        AppUser appUser = iAppUserRepo.findByEmail(mail);
        return  appUser;
    }

    public AppUser save(AppUser appUser){
        return iAppUserRepo.save(appUser);
    }

    public AppUser findById(long id){
        return iAppUserRepo.findById(id).get();
    }
}
