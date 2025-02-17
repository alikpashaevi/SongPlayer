package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import springdemo_4.springdemo_4.entity.Artist;
import springdemo_4.springdemo_4.entity.ArtistRepository;
import springdemo_4.springdemo_4.model.ArtistDTO;
import springdemo_4.springdemo_4.model.ArtistRequest;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Page<ArtistDTO> getArtists(int page, int pageSize) {
        return artistRepository.findArtists(PageRequest.of(page, pageSize));
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
