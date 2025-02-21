package springdemo_4.springdemo_4.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongSimpleDTO {
    private Long id;
    private String name;
    private Double duration;
}
