package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
 
    //se obtiene una Categoria, a partir del id de una Categoria
    public Categoria getCategoria(Categoria categoria);
    
    //se inserta una nueva Categoria si el id de la Categoria está vacía
    //se actualiza una Categoria si el id de la categoría No está vacia
    public void save(Categoria categoria); 
    
    //se elimina la Categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria);
}
