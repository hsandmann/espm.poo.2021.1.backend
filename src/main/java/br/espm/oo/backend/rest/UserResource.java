package br.espm.oo.backend.rest;

import br.espm.oo.backend.datatype.UserBean;
import br.espm.oo.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<UserBean> listAll() {
        return userService.listAll();
    }

    @GetMapping(path = "/users/{id}")
    public UserBean findBy(@PathVariable UUID id) {
        return userService.findBy(id);
    }

    @PostMapping(path = "/users")
    public void save(@RequestBody UserBean user) {
        userService.create(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteBy(@PathVariable UUID id) {
        userService.delete(id);
    }

}
