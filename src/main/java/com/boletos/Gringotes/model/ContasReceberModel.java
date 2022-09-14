package com.boletos.Gringotes.model;

import com.boletos.Gringotes.enums.RecebimentoAlugueis;
import com.boletos.Gringotes.enums.Status;
import com.boletos.Gringotes.enums.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contasreceber")
public class ContasReceberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 50, nullable = false)
    private Status status;
    @Column(length = 50, nullable = false)
    private String recebimento;

    @Column(length = 50, nullable = false)
    private BigDecimal valorRecebido;

    @Column(length = 50, nullable = false)
    private TipoRecebimento tipoRecebimento;

    @Column(length = 50, nullable = false)
    private RecebimentoAlugueis recebimentoAlugueis;

    @Column(length = 50, nullable = false)
    private LocalDate dataDeVencimento;

    @Column(length = 50, nullable = false)
    private LocalDate dataDeRecebimento;
    @Column(length = 50, nullable = false)
private  BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuario;

}
