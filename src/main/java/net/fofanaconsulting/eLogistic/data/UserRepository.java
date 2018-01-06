package net.fofanaconsulting.eLogistic.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.fofanaconsulting.eLogistic.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  User findByUsername(String username);

}
