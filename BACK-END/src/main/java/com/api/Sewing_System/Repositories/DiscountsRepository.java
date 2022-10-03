package com.api.Sewing_System.Repositories;

import com.api.Sewing_System.Models.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountsRepository extends JpaRepository<Discounts, Long>{
}
