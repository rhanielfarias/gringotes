package com.boletos.Gringotes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gerenciador")
public class ContasAPagarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private double valor;

    @Column(length = 50, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 50, nullable = false)
    private LocalDateTime dataDePagamento;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(length = 50, nullable = false)
    private String tipo;

}
