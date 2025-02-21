package springdemo_4.springdemo_4.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongDTO {
    private Long id;
    private String name;
    private Double duration;
    private AlbumDTO album;
    private ArtistDTO artist;
}
