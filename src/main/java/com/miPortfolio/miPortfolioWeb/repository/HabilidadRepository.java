package com.miPortfolio.miPortfolioWeb.repository;

import com.miPortfolio.miPortfolioWeb.model.Educacion;
import com.miPortfolio.miPortfolioWeb.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
    void deleteHabilidadById(Long id);

    Optional<Habilidad> findHabilidadById(Long id);
}
