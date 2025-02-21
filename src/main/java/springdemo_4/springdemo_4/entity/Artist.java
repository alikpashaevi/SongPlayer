package springdemo_4.springdemo_4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "artist")
@SequenceGenerator(name = "artist_seq_gen", sequenceName = "artist_seq", allocationSize = 1)
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(generator = "artist_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "monthly_listeners")
    private String monthlyListeners;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Album> albums;

}
