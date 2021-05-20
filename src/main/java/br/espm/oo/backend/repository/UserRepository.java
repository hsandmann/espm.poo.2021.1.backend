package br.espm.oo.backend.repository;

import br.espm.oo.backend.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
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

    @Query("SELECT u FROM UserModel u WHERE UPPER(u.txName) LIKE(UPPER(CONCAT('%',:name,'%')))") // JPQL
    List<UserModel> listByUserName(@Param("name") String name);

}
