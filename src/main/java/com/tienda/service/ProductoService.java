package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    public List<Producto> findByInventarioMayor(int minExistencias);
    
     //Ejemplo de método utilizando Consultas con JPQL
    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}