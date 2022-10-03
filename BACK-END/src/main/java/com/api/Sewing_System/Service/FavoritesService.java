package com.api.Sewing_System.Service;

import com.api.Sewing_System.Models.Favorites;
import com.api.Sewing_System.Repositories.FavoriteRepository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class FavoritesService {

    final FavoriteRepository favoriteRepository;

    public FavoritesService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Transactional
    public Favorites save(Favorites favorites) {return favoriteRepository.save(favorites);}

    public List<Favorites> findAll() {
        return favoriteRepository.findAll();
    }

    @Transactional
    public void delete(Favorites favorites) {
        favoriteRepository.delete(favorites);
    }

    public Optional<Favorites> findById(Long id) {
        return favoriteRepository.findById(id);
    }
}
