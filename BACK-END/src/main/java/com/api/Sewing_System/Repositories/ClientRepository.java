package com.api.Sewing_System.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.Sewing_System.Models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}