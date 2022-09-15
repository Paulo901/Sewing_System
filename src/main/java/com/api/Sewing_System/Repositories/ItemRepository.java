package com.api.Sewing_System.Repositories;

import com.api.Sewing_System.Models.ItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<ItemsModel, UUID> {
}