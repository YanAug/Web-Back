package com.unievangelica.progwebback.dominio.categoria;

import com.unievangelica.progwebback.dominio.produto.Produto;
import com.unievangelica.progwebback.dominio.produto.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

    @Autowired
    private CategoriaServico categoriaServico;

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Categoria categoria){
        return new ResponseEntity(categoriaServico.salvar(categoria), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Categoria categoria){
        return new ResponseEntity(categoriaServico.salvar(categoria), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{categoriaId}")
    public ResponseEntity<?> excluir(@PathVariable Long categoriaId) {
        return new ResponseEntity(categoriaServico.excluir(categoriaId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(categoriaServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{categoriaId}")
    public ResponseEntity<?> findById(@PathVariable Long categoriaId) {
        return new ResponseEntity(categoriaServico.buscarPeloId(categoriaId), HttpStatus.OK);
    }

}
