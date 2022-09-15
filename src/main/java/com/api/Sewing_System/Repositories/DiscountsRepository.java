package com.api.Sewing_System.Repositories;

import com.api.Sewing_System.Models.DiscountsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DiscountsRepository extends JpaRepository<DiscountsModel, UUID> {
}
