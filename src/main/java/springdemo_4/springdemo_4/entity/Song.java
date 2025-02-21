package springdemo_4.springdemo_4.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "song")
@SequenceGenerator(name = "song_seq_gen", sequenceName = "song_seq", allocationSize = 1)
@Getter
@Setter
public class Song {

    @Id
    @GeneratedValue(generator = "song_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Double duration;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

}
