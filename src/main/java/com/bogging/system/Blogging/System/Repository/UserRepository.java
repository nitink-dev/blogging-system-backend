package com.bogging.system.Blogging.System.Repository;

import com.bogging.system.Blogging.System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

