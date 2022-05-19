package com.miPortfolio.miPortfolioWeb.repository;


import com.miPortfolio.miPortfolioWeb.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    void deletePoyectoById(Long id);

    Optional<Proyecto> findProyectoById(Long id);
}
