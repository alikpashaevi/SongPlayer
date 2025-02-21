package springdemo_4.springdemo_4.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "album")
@SequenceGenerator(name = "album_seq_gen", sequenceName = "album_seq", allocationSize = 1)
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue(generator = "album_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_year")
    private int releaseYear;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @OneToMany(mappedBy = "album" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs;
}
