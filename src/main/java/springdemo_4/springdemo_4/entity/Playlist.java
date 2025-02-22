package springdemo_4.springdemo_4.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
@SequenceGenerator(name = "playlist_seq_gen", sequenceName = "album_seq", allocationSize = 1)
@Getter
@Setter
public class Playlist {

    @Id
    @GeneratedValue(generator = "playlist_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "playlist_song",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> songs = new ArrayList<>();

}
