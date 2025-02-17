package springdemo_4.springdemo_4.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import springdemo_4.springdemo_4.entity.Album;
import springdemo_4.springdemo_4.entity.AlbumRepository;
import springdemo_4.springdemo_4.model.AlbumDTO;
import springdemo_4.springdemo_4.model.AlbumRequest;

@org.springframework.stereotype.Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Page<AlbumDTO> getAlbums(int page, int pageSize) {
        return albumRepository.findAlbums(PageRequest.of(page, pageSize));
    }

    public Album findAlbum(Long id) {
        return albumRepository.findById(id).get();
    }

    public void createAlbum(AlbumRequest request) {
        Album newAlbum = new Album();
        newAlbum.setName(request.getName());
        newAlbum.setReleaseYear(request.getReleaseYear());

        albumRepository.save(newAlbum);
    }

    public void updateAlbum(Long id, AlbumRequest request) {
        Album updatedAlbum = albumRepository.findById(id).get();
        updatedAlbum.setName(request.getName());
        updatedAlbum.setReleaseYear(request.getReleaseYear());

        albumRepository.save(updatedAlbum);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

}
