package com.boletos.Gringotes.model;

import com.boletos.Gringotes.enums.Status;
import com.boletos.Gringotes.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
@NotBlank(message = "Nome obrigatório")
@Length(min = 5, max = 20, message = "O nome precisa ter no mínimo 5 caracter e no máximo 20")
    private String nome;

    @Column(length = 50, nullable = false)
    private double valor;

    @Column(length = 50, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 50, nullable = true)
    private LocalDateTime dataDePagamento;

    @Column(length = 50, nullable = false)
    private Status status;

    @Column(length = 50, nullable = false)
    private Tipo tipo;

}
