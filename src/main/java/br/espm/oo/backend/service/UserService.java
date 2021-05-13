package br.espm.oo.backend.service;

import br.espm.oo.backend.datatype.UserBean;
import br.espm.oo.backend.model.UserModel;
import br.espm.oo.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserBean> listAll() {
        List<UserBean> l = new ArrayList<>();
        userRepository.findAll().forEach(userModel -> l.add(userModel.to()));
        return l;
    }

    public UserBean findBy(UUID id) {
        Optional<UserModel> um = userRepository.findById(id.toString());
        return um.isEmpty() ? null : um.get().to();
    }

    public UserBean create(UserBean user) {
        user.setId(UUID.randomUUID());
        return userRepository.save(new UserModel(user)).to();
    }

    public void delete(UUID id) {
        userRepository.deleteById(id.toString());
    }

}
