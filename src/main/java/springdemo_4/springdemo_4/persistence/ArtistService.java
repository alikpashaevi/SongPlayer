package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.Album;
import springdemo_4.springdemo_4.entity.Artist;
import springdemo_4.springdemo_4.entity.ArtistRepository;
import springdemo_4.springdemo_4.model.AlbumDTO;
import springdemo_4.springdemo_4.model.ArtistDTO;
import springdemo_4.springdemo_4.model.ArtistRequest;
import springdemo_4.springdemo_4.model.ArtistSimpleDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
                        .map(album -> new AlbumDTO(
                                album.getId(),
                                album.getName(),
                                album.getReleaseYear(),
                                artistSimpleDTO
                        ))
                        .collect(Collectors.toList())
        );
    }



    public Artist findArtist(Long id) {
        return artistRepository.findById(id).get();
    }

    public void createArtist(ArtistRequest request) {
        Artist newArtist = new Artist();
        newArtist.setName(request.getName());
        newArtist.setMonthlyListeners(request.getMonthlyListeners());

        artistRepository.save(newArtist);
    }

    public void updateArtist(Long id, ArtistRequest request) {
        Artist updatedArtist = artistRepository.findById(id).get();
        updatedArtist.setName(request.getName());
        updatedArtist.setMonthlyListeners(request.getMonthlyListeners());

        artistRepository.save(updatedArtist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

}
