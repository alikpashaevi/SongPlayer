package springdemo_4.springdemo_4.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import springdemo_4.springdemo_4.entity.Playlist;

import java.util.List;

@Data
@AllArgsConstructor
public class PlaylistDTO {
    private Long id;
    private String name;
    private List<SongSimpleDTO> songs;

}
