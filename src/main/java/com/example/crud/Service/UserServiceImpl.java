package com.example.crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.crud.dto.UserDto;
import com.example.crud.Models.User;
import com.example.crud.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
   
    @Autowired
    private PasswordEncoder passwordEncoder;
   
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(), userDto.getFullname());
        return userRepository.save(user);
    }
}
