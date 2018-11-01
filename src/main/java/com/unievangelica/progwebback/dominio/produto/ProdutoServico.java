package com.unievangelica.progwebback.dominio.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;


    public Produto salvar(Produto produto){
        return produtoRepositorio.save(produto);
    }

    public boolean excluir(Long produtoId){
        Produto produtoBusca = produtoRepositorio.getOne(produtoId);
        if( produtoBusca != null ){
            produtoRepositorio.delete(produtoBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Produto buscarPeloId(Long produtoId){
        return produtoRepositorio.getOne(produtoId);
    }

    public List<Produto> buscarTodos(){
        return produtoRepositorio.findAll();
    }

}
