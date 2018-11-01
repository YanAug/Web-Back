package com.unievangelica.progwebback.dominio.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoControlador {

    @Autowired
    private ProdutoServico produtoServico;

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Produto produto){
        return
                new ResponseEntity(produtoServico.salvar(produto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Produto produto){
        return new ResponseEntity(produtoServico.salvar(produto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{produtoId}")
    public ResponseEntity<?> excluir(@PathVariable Long produtoId) {
        return new ResponseEntity(produtoServico.excluir(produtoId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(produtoServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{produtoId}")
    public ResponseEntity<?> findById(@PathVariable Long produtoId) {
        return new ResponseEntity(produtoServico.buscarPeloId(produtoId), HttpStatus.OK);
    }



}
