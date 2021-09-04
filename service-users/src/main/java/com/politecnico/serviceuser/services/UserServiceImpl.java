package com.politecnico.serviceuser.services;

import com.politecnico.serviceuser.entities.User;
import com.politecnico.serviceuser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
