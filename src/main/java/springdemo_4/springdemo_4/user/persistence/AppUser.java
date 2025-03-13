package springdemo_4.springdemo_4.user.persistence;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user", schema = "songs")
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(generator = "user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

}
