package com.project.loginForm.repository;

import com.project.loginForm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);
    boolean existsByEmail(String email);
}
