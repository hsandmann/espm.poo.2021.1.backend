package br.espm.oo.backend.repository;

import br.espm.oo.backend.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, String> {

    @Override
    Iterable<UserModel> findAll();

    @Override
    Optional<UserModel> findById(String s);

    @Override
    UserModel save(UserModel user);

    @Override
    void deleteById(String s);

}
