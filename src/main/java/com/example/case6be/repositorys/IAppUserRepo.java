package com.example.case6be.repositorys;

import com.example.case6be.models.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    @Query(nativeQuery = true,value = "SELECT * FROM case6.app_user where email =:email")
    AppUser findByEmail(@Param("email") String email);
}
