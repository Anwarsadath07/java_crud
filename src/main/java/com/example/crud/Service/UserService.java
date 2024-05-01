package com.example.crud.Service;


import com.example.crud.dto.UserDto;
import com.example.crud.Models.User;


public interface UserService {


    User save (UserDto userDto);
}