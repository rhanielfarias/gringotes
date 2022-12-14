package com.boletos.Gringotes.controller;

import com.boletos.Gringotes.enums.TipoRecebimento;
import com.boletos.Gringotes.model.ContasReceberModel;
import com.boletos.Gringotes.model.valorrecebimento.EfetuarRecebimento;
import com.boletos.Gringotes.service.ContaReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ContasReceberController {
    @Autowired
    private ContaReceberService contaReceberService;

    @GetMapping(path = "/contasreceber/{status}")
    public ResponseEntity<List<ContasReceberModel>> buscarStatus(String status) {
        return ResponseEntity.ok(contaReceberService.buscarPorStatus(status));
    }

    @GetMapping(path = "/contasreceber/{tipoderecebimento}")
    public ResponseEntity<List<ContasReceberModel>> buscarPorTipoDeRecebimento(TipoRecebimento tipoRecebimento) {
        return ResponseEntity.ok(contaReceberService.buscarTipo(tipoRecebimento));
    }

    @GetMapping(path = "/contasreceber/{datavencida}")
    public ResponseEntity<List<ContasReceberModel>> buscarPorDataVencida(LocalDate dataVencida) {
        return ResponseEntity.ok(contaReceberService.buscarDataVencida(dataVencida));
    }

    @GetMapping(path = "/contasreceber")
    public ResponseEntity<List<ContasReceberModel>> buscarPorContas() {
        return ResponseEntity.ok(contaReceberService.buscarTodos());
    }

    @GetMapping(path = "/contasreceber/{codigo}")
    public ResponseEntity<Optional<ContasReceberModel>> buscarId(@PathVariable Integer codigo) {
        return ResponseEntity.ok(contaReceberService.buscarId(codigo));
    }

    @PostMapping(path = "/contasreceber")
    public ResponseEntity<ContasReceberModel> cadastrarContas(@RequestBody ContasReceberModel contasReceberModel, EfetuarRecebimento efetuarRecebimento) {
        ContasReceberModel contas = contaReceberService.cadastrar(contasReceberModel, efetuarRecebimento);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @PutMapping(path = "/contasreceber/{codigo}")
    public ResponseEntity<ContasReceberModel> alterarContas(@RequestBody ContasReceberModel contas, @PathVariable Integer codigo) {
        return ResponseEntity.ok(contaReceberService.alterar(contas, codigo));
    }

    @DeleteMapping(path = "/contasreceber/{codigo}")
    public void deletarContas(@PathVariable Integer codigo) {
        contaReceberService.deletar(codigo);
    }


}
