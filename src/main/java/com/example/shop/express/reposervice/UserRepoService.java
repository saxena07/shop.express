package com.example.shop.express.reposervice;

import com.example.shop.express.entity.User;
import com.example.shop.express.model.request.user.UserDetailsRequest;
import com.example.shop.express.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepoService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);

    }

    @Named("getUser")
    public User getDetails(final Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);

    }

    public User getDetails(UserDetailsRequest userDetailsRequest) {
        //need help in writing query or to use jpa
        Optional<User> userOptional =
                userRepository.findUserByEmailContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        userDetailsRequest.getEmail(), userDetailsRequest.getFirstName(),
                        userDetailsRequest.getLastName());
        //
        //  throw new Exception(ErrorConstants.USER_NOT_FOUND);
        return userOptional.orElse(null);

    }


}
