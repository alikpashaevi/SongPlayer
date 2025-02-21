package springdemo_4.springdemo_4.model;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import springdemo_4.springdemo_4.validation.ValidReleaseYear;

import java.time.Year;

@Data
@AllArgsConstructor
public class AlbumRequest {
    @NotBlank
    @Size(min = 1, max = 120)
    private String name;
    @ValidReleaseYear
    private int releaseYear;
    @Positive
    private Long artistId;
}
