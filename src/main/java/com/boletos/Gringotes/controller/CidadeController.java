package com.boletos.Gringotes.controller;


import com.boletos.Gringotes.model.CidadeModel;
import com.boletos.Gringotes.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping(path = "/cidade")
    public ResponseEntity<List<CidadeModel>> buscarPorCidade() {
        return ResponseEntity.ok(cidadeService.buscarPorTodos());
    }

    @GetMapping(path = "/cidade/{codigo}")
    public ResponseEntity<Optional<CidadeModel>> buscarId(@PathVariable Integer codigo) {
        return ResponseEntity.ok(cidadeService.buscarId(codigo));
    }

    @PostMapping(path = "/cidade")
    public ResponseEntity<CidadeModel> cadastrarCidade(@RequestBody CidadeModel cidadeModel) {
        CidadeModel cidade = cidadeService.cadastrar(cidadeModel);
        return new ResponseEntity<>(cidade, HttpStatus.CREATED);
    }

    @PutMapping(path = "/cidade/{codigo}")
    public ResponseEntity<CidadeModel> alterarCidade(@RequestBody CidadeModel cidadeModel, @PathVariable Integer codigo) {
        return ResponseEntity.ok(cidadeService.alterar(cidadeModel, codigo));
    }

    @DeleteMapping(path = "/cidade/{codigo}")
    public void deletar(@PathVariable Integer codigo) {
        cidadeService.deletar(codigo);


    }
}
