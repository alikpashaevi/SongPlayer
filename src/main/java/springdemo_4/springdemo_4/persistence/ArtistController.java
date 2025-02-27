package springdemo_4.springdemo_4.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.model.ArtistDTO;
import springdemo_4.springdemo_4.model.ArtistRequest;

import static springdemo_4.springdemo_4.constants.AuthorizationConstants.ADMIN;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
@PreAuthorize(ADMIN)
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public Page<ArtistDTO> getArtists(@RequestParam int page, @RequestParam int pageSize) {
        return artistService.getArtists(page, pageSize);
    }

    @GetMapping("/{id}")
    public ArtistDTO getArtist(@PathVariable Long id) {
        return artistService.findArtist(id);
    }

    @PostMapping
    public void createArtist(@RequestBody ArtistRequest request) {
        artistService.createArtist(request);
    }

    @PutMapping("/{id}")
    public void updateArtist(@PathVariable Long id, @RequestBody ArtistRequest request) {
        artistService.updateArtist(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }

}
