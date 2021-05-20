package br.espm.oo.backend.service;

import br.espm.oo.backend.datatype.UserBean;
import br.espm.oo.backend.model.UserModel;
import br.espm.oo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserBean> listAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(UserModel::to)
                .collect(Collectors.toList());
    }

    public UserBean findBy(UUID id) {
        return userRepository
                .findById(id.toString())
                .map(userModel -> userModel.to())
                .orElse(null);
    }

    public List<UserBean> listByName(String name) {
        return userRepository.listByUserName(name)
                .stream().map(UserModel::to)
                .collect(Collectors.toList());
    }

    public UserBean create(UserBean user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(new UserModel(user)).to();
    }

    public void delete(UUID id) {
        userRepository.deleteById(id.toString());
    }

}
