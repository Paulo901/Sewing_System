package com.api.Sewing_System.Repositories;

import com.api.Sewing_System.Models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorites, Long>{
}
