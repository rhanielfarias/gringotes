package com.boletos.Gringotes.controller;

import com.boletos.Gringotes.enums.Status;
import com.boletos.Gringotes.enums.Tipo;
import com.boletos.Gringotes.model.ContasAPagarModel;
import com.boletos.Gringotes.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
public class ContasAPagarController {
    @Autowired
    private ContasAPagarService contasAPagarService;

    @GetMapping(path = "/contas/tipo/{tipo}")
    public List<ContasAPagarModel> findByTipo(@PathVariable Tipo tipo) {
        return contasAPagarService.findByTipo(tipo);
    }

    @GetMapping(path = "/contas/status/{status}")
    public List<ContasAPagarModel> findByStatus(@PathVariable Status status) {
        return contasAPagarService.findByStatus(status);
    }

    @GetMapping(path = "/contas")
    public ResponseEntity<List<ContasAPagarModel>> buscarPorContas() {
        return ResponseEntity.ok(contasAPagarService.buscarTodos());
    }

    @GetMapping(path = "/contas/{codigo}")
    public ResponseEntity<Optional<ContasAPagarModel>> buscarId(@PathVariable Long codigo) {
        return ResponseEntity.ok(contasAPagarService.buscarId(codigo));
    }

    @PostMapping(path = "/contas")
    public ResponseEntity<ContasAPagarModel> cadastrarContas(@RequestBody ContasAPagarModel contasAPagarModel) {
        ContasAPagarModel contas = contasAPagarService.cadastrar(contasAPagarModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @PutMapping(path = "/contas/{codigo}")
    public ResponseEntity<ContasAPagarModel> alterarContas(@RequestBody ContasAPagarModel contas) {
        return ResponseEntity.ok(contasAPagarService.alterar(contas));
    }

    @DeleteMapping(path = "/contas/{codigo}")
    public void deletarContas(@PathVariable Long codigo) {
        contasAPagarService.deletar(codigo);
    }
}
