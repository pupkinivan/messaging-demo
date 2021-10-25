package com.ivanpupkin.usersigninservice.repository;

import com.ivanpupkin.usersigninservice.models.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Boolean existsByEmailAddress(String emailAddress);
}
