package com.validation.formlogin.service.iml;

import com.validation.formlogin.model.User;
import com.validation.formlogin.repository.UserRepository;
import com.validation.formlogin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
