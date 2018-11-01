package com.unievangelica.progwebback.dominio.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;


    public Categoria salvar(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }

    public boolean excluir(Long categoriaId){
        Categoria categoriaBusca = categoriaRepositorio.getOne(categoriaId);
        if( categoriaBusca != null ){
            categoriaRepositorio.delete(categoriaBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Categoria buscarPeloId(Long categoriaId){
        return categoriaRepositorio.getOne(categoriaId);
    }

    public List<Categoria> buscarTodos(){
        return categoriaRepositorio.findAll();
    }

}
