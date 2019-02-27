package com.example.glucosemonitor.data;

import com.example.glucosemonitor.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
