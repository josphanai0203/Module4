package app.service;

import app.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SongService implements ISongService{
    private List<Song> products = new ArrayList<>();
    @Override
    public List<Song> findAll() {
        return products;
    }

    @Override
    public void save(Song song) {
        products.add(song);
    }

    @Override
    public Song findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Song song) {
        for (Song p : products) {
            if (p.getId() == id) {
                p = song;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }
}
