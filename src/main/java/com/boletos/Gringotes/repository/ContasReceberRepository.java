package com.boletos.Gringotes.repository;

import com.boletos.Gringotes.enums.TipoRecebimento;
import com.boletos.Gringotes.model.ContasReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContasReceberRepository extends JpaRepository<ContasReceberModel, Integer> {

}
