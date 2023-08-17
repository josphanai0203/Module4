package app.service;

import app.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(Song song);

    void remove(Song song);
}
