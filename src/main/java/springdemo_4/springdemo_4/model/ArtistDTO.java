package springdemo_4.springdemo_4.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtistDTO {
    private Long id;
    private String name;
    private String monthlyListeners;
    private List<AlbumDTO> albums;
}
