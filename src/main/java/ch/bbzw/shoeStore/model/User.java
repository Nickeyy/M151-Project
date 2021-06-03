package ch.bbzw.shoeStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shoestore_user")
@NamedQuery(name = "User.checkPassword", query = "SELECT u FROM User u WHERE u.username = :username and password = public.crypt(text(:password), text(password))")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(allocationSize = 1, name = "user_sequence")
    @Column(nullable = false, updatable = false)
    private long user_id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

   @JsonProperty(access = JsonProperty.Access.READ_WRITE)
   @Column(nullable = false)
   @ColumnTransformer(write = "crypt(?, gen_salt('bf', 8))")
    private String password;

   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private UserGroup userGroup;

    protected User() {
    }

    public User(final String username, final String firstname, final String lastname, final String password, final UserGroup userGroup) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.userGroup = userGroup;
    }

    public long getUser_id() {
        return user_id;
    }
    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }
}
