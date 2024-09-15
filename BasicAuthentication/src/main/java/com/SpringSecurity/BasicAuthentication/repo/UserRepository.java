package com.SpringSecurity.BasicAuthentication.repo;

import com.SpringSecurity.BasicAuthentication.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);

    void deleteByUsername(String username);
}