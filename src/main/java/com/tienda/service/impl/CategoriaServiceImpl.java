package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    // Se obtiene un Categoria, a partir del id de un categoria
    @Override
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria){
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    @Override
    @Transactional
    public void save(Categoria categoria){
        categoriaDao.save(categoria);
    }

    // Se elimina el categoria que tiene el id pasado por parámetro
    @Override
    @Transactional
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }
}