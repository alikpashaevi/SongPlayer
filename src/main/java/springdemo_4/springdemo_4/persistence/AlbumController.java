package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.entity.Album;
import springdemo_4.springdemo_4.model.AlbumDTO;
import springdemo_4.springdemo_4.model.AlbumRequest;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService AlbumService) {
        this.albumService = AlbumService;
    }

    @GetMapping
    public Page<AlbumDTO> getAlbums(@RequestParam int page,@RequestParam int pageSize) {
        return albumService.getAlbums(page, pageSize);
    }

    @GetMapping("/{id}")
    public AlbumDTO getAlbum(@PathVariable Long id) {
        return albumService.findAlbum(id);
    }

    @PostMapping
    ResponseEntity<Void> createAlbum(@RequestBody AlbumRequest request) {
        albumService.createAlbum(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateAlbum(@PathVariable Long id, @RequestBody AlbumRequest request) {
        albumService.updateAlbum(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.ok().build();
    }


}
