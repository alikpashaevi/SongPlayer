package springdemo_4.springdemo_4.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongRequest {
    @NotBlank
    @Size(min = 1, max = 120)
    private String name;
    @NotNull
    @Positive
    private Double duration;
    @NotNull
    @Positive
    private Long AlbumId;
    @NotNull
    @Positive
    private Long artistId;
}
