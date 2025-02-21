package springdemo_4.springdemo_4.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtistRequest {
    @NotBlank
    @Size(min = 1, max = 120)
    private String name;
    @Positive
    private String monthlyListeners;
}
