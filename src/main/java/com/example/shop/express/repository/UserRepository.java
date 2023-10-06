package com.example.shop.express.repository;

import com.example.shop.express.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


//    Optional<User> findByFilter(Integer id, String firstName, String LastName ,String email,
//                                UserType type);
    Optional<User> findUserByEmailContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String email, String firstName, String lastName);
    @Query(value = "select users from users limit 1",nativeQuery = true)
    //has to be changed
    Optional<User> fetchUserFilter(User user);
   // Optional<User> findByUser(User user);




}
