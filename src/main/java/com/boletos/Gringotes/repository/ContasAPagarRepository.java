package com.boletos.Gringotes.repository;

import com.boletos.Gringotes.enums.Status;
import com.boletos.Gringotes.enums.Tipo;
import com.boletos.Gringotes.model.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {
    public List<ContasAPagarModel> findByStatus(Status status);

    public List<ContasAPagarModel> findByTipo(Tipo tipo);

}
