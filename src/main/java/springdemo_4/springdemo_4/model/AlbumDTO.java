package springdemo_4.springdemo_4.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AlbumDTO {
    private Long id;
    private String name;
    private int ReleaseYear;
    private ArtistSimpleDTO artist;
    private List<SongSimpleDTO> songs;
}
