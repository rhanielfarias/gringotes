package com.boletos.Gringotes.repository;

import com.boletos.Gringotes.model.ContasAPagarModel;
    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {
}
