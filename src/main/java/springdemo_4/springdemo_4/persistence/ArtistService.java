package springdemo_4.springdemo_4.persistence;

import org.hibernate.annotations.NotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.Album;
import springdemo_4.springdemo_4.entity.Artist;
import springdemo_4.springdemo_4.entity.ArtistRepository;
import springdemo_4.springdemo_4.error.NotFoundException;
import springdemo_4.springdemo_4.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    private NotFoundException buildNotFoundException(long id) {
        return new NotFoundException("Artist with id " + id + " not found");
    }

    public Page<ArtistDTO> getArtists(int page, int pageSize) {
//        return artistRepository.findArtists(PageRequest.of(page, pageSize));
        Page<Artist> artists = artistRepository.findArtists(PageRequest.of(page, pageSize));
        return artists.map(this::convertToArtistDTO);
    }

    private ArtistDTO convertToArtistDTO(Artist artist) {
        ArtistSimpleDTO artistSimpleDTO = new ArtistSimpleDTO(
                artist.getId(),
                artist.getName(),
                artist.getMonthlyListeners()
        );

        return new ArtistDTO(
                artist.getId(),
                artist.getName(),
                artist.getMonthlyListeners(),
                artist.getAlbums().stream()
                        .map(album -> new AlbumSimpleDTO(
                                album.getId(),
                                album.getName(),
                                album.getReleaseYear()
                        ))
                        .collect(Collectors.toList())
        );
    }

    public Artist findArtistForOthers(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
    }

    public ArtistDTO findArtist(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        return convertToArtistDTO(artist);
    }

    public void createArtist(ArtistRequest request) {
        Artist newArtist = new Artist();
        newArtist.setName(request.getName());
        newArtist.setMonthlyListeners(request.getMonthlyListeners());

        artistRepository.save(newArtist);
    }

    public void updateArtist(Long id, ArtistRequest request) {
        Artist updatedArtist = artistRepository.findById(id).orElseThrow(() -> buildNotFoundException(id));
        updatedArtist.setName(request.getName());
        updatedArtist.setMonthlyListeners(request.getMonthlyListeners());

        artistRepository.save(updatedArtist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

}
