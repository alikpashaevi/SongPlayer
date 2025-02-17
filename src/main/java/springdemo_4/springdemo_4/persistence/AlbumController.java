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

    public AlbumController(AlbumService playlistAlbumService) {
        this.albumService = playlistAlbumService;
    }

    @GetMapping
    public Page<AlbumDTO> getPlaylists(int page, int pageSize) {
        return albumService.getAlbums(page, pageSize);
    }

    @GetMapping("/{id}")
    public Album getPlaylist(Long id) {
        return albumService.findAlbum(id);
    }

    @PostMapping
    ResponseEntity<Void> createPlaylist(@RequestBody AlbumRequest request) {
        albumService.createAlbum(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updatePlaylist(@PathVariable Long id, @RequestBody AlbumRequest request) {
        albumService.updateAlbum(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.ok().build();
    }


}
