package br.espm.oo.backend.model;

import br.espm.oo.backend.datatype.UserBean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="users")
public class UserModel {

    @Id
    private String idUsers;
    private String txName;

    public UserModel() {

    }

    public UserModel(UserBean b) {
        this.idUsers = b.getId().toString();
        this.txName = b.getName();
    }

    public UserBean to() {
        UserBean b = new UserBean();
        b.setId(UUID.fromString(idUsers));
        b.setName(txName);
        return b;
    }

}
