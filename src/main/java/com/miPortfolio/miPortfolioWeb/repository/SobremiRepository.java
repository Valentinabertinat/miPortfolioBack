package com.miPortfolio.miPortfolioWeb.repository;

import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Sobremi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SobremiRepository extends JpaRepository<Sobremi, Long> {
    void deleteSobremiById(Long id);

    Optional<Sobremi> findSobremiById(Long id);
}
