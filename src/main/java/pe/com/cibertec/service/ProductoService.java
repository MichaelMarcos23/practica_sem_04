package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.model.ProductoEntity;

public interface ProductoService {
	List<ProductoEntity>listarProducto();
	void crearProducto(ProductoEntity productoEntity);
	ProductoEntity buscarProductoPorId(Integer id);
	void actualizarProducto(Integer id, ProductoEntity productoEntity);
	void eliminarProducto(Integer id);
	

}
