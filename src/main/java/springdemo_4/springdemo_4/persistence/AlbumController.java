package springdemo_4.springdemo_4.persistence;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springdemo_4.springdemo_4.model.AlbumDTO;
import springdemo_4.springdemo_4.model.AlbumRequest;

import static springdemo_4.springdemo_4.security.AuthorizationConstants.ARTIST_OR_ADMIN;
import static springdemo_4.springdemo_4.security.AuthorizationConstants.USER_OR_ARTIST_OR_ADMIN;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    @PreAuthorize(USER_OR_ARTIST_OR_ADMIN)
    public Page<AlbumDTO> getAlbums(@RequestParam int page,@RequestParam int pageSize) {
        return albumService.getAlbums(page, pageSize);
    }

    @GetMapping("/{id}")
    @PreAuthorize(USER_OR_ARTIST_OR_ADMIN)
    public AlbumDTO getAlbum(@PathVariable Long id) {
        return albumService.findAlbum(id);
    }

    @PostMapping
    @PreAuthorize(ARTIST_OR_ADMIN)
    ResponseEntity<Void> createAlbum(@RequestBody @Valid AlbumRequest request) {
        albumService.createAlbum(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize(ARTIST_OR_ADMIN)
    ResponseEntity<Void> updateAlbum(@PathVariable Long id, @RequestBody @Valid AlbumRequest request) {
        albumService.updateAlbum(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(ARTIST_OR_ADMIN)
    ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.ok().build();
    }

}
