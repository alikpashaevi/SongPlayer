package springdemo_4.springdemo_4.persistence;

import org.hibernate.annotations.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import springdemo_4.springdemo_4.entity.Album;
import springdemo_4.springdemo_4.entity.AlbumRepository;
import springdemo_4.springdemo_4.entity.Artist;
import springdemo_4.springdemo_4.error.NotFoundException;
import springdemo_4.springdemo_4.model.AlbumDTO;
import springdemo_4.springdemo_4.model.AlbumRequest;
import springdemo_4.springdemo_4.model.ArtistSimpleDTO;

import java.util.Objects;

@org.springframework.stereotype.Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistService artistService;

    public AlbumService(AlbumRepository albumRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.artistService = artistService;
    }

    private NotFoundException buildNotFoundException(long id) {
        return new NotFoundException("Album with id " + id + " not found");
    }

    public Page<AlbumDTO> getAlbums(int page, int pageSize) {
        // Fetch albums with artists from the repository
        Page<Album> albums = albumRepository.findAlbums(PageRequest.of(page, pageSize));

        // Map entities to DTOs
        return albums.map(this::convertToAlbumDTO);
    }

    private AlbumDTO convertToAlbumDTO(Album album) {
        // Create ArtistSimpleDTO
        ArtistSimpleDTO artistSimpleDTO = new ArtistSimpleDTO(
                album.getArtist().getId(),
                album.getArtist().getName(),
                album.getArtist().getMonthlyListeners()
        );

        // Create AlbumDTO
        return new AlbumDTO(
                album.getId(),
                album.getName(),
                album.getReleaseYear(),
                artistSimpleDTO
        );
    }

    public Album findAlbum(Long id) {
        return albumRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
    }

    public void createAlbum(AlbumRequest request) {
        Album newAlbum = new Album();
        newAlbum.setName(request.getName());
        newAlbum.setReleaseYear(request.getReleaseYear());
        newAlbum.setArtist(artistService.findArtist(request.getArtistId()));
        albumRepository.save(newAlbum);
    }

    public void updateAlbum(Long id, AlbumRequest request) {
        Album updatedAlbum = albumRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        updatedAlbum.setName(request.getName());
        updatedAlbum.setReleaseYear(request.getReleaseYear());
        if(!Objects.equals(request.getArtistId(), updatedAlbum.getArtist().getId())) {
            updatedAlbum.setArtist(artistService.findArtist(request.getArtistId()));
        }

        albumRepository.save(updatedAlbum);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

}
