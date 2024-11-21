package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    // Se obtiene un listado de Productos en un List
    public List<Producto> getProductos(boolean activos);
 
    //se obtiene una Producto, a partir del id de una Producto
    public Producto getProducto(Producto producto);
    
    //se inserta una nueva Producto si el id de la Producto está vacía
    //se actualiza una Producto si el id de la categoría No está vacia
    public void save(Producto producto); 
    
    //se elimina la Producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
}