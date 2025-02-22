package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.entity.Artist;
import springdemo_4.springdemo_4.model.ArtistDTO;
import springdemo_4.springdemo_4.model.ArtistRequest;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

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
