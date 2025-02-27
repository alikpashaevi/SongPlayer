package springdemo_4.springdemo_4.user.persistence;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role", schema = "songs")
@Getter
@Setter
public class Role {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

}
