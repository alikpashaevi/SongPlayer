ALTER TABLE songs.album
ADD COLUMN artist_id BIGINT;

ALTER TABLE songs.album
ADD CONSTRAINT fk_album_artist
FOREIGN KEY (artist_id) REFERENCES songs.artist(ID);