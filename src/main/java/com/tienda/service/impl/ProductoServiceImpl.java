package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoDao ProductoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista=ProductoDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
     @Override
    @Transactional(readOnly=true)
     public Producto getProducto(Producto Producto){
         return ProductoDao.findById(Producto.getIdProducto()).orElse(null);
     }
     
     @Override
     @Transactional(readOnly=true)
      public void save(Producto Producto) {
          ProductoDao.save(Producto);
      }
      
      @Override
      @Transactional(readOnly=true)
      public void delete(Producto Producto){
          ProductoDao.delete(Producto);
      }

}