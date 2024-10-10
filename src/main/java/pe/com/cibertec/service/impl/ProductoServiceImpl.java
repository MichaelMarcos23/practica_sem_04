package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.repository.ProductoRepository;
import pe.com.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl  implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public List<ProductoEntity> listarProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public void crearProducto(ProductoEntity productoEntity) {
		// TODO Auto-generated method stub
		productoRepository.save(productoEntity);
		
	}

	@Override
	public ProductoEntity buscarProductoPorId(Integer id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	@Override
	public void actualizarProducto(Integer id, ProductoEntity productoActualizado) {
		ProductoEntity productoEncontrado = buscarProductoPorId(id);
		if(productoEncontrado == null) {
			throw new RuntimeException("producto no encontrado");
		}
		try {
			productoEncontrado.setNombreProducto(productoActualizado.getNombreProducto());
			productoEncontrado.setPrecio(productoActualizado.getPrecio());
			productoEncontrado.setCantidad(productoActualizado.getCantidad());
			productoEncontrado.setFechaVencimiento(productoActualizado.getFechaVencimiento());
			productoEncontrado.setCategoriaEntity(productoActualizado.getCategoriaEntity());
			productoRepository.save(productoEncontrado);
		}catch (Exception e) {
			throw new RuntimeException("Error al actualizar");
		}
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		ProductoEntity productoEncontrado = buscarProductoPorId(id);
		if(productoEncontrado == null) {
			throw new RuntimeException("Producto no encontrado");
		}
		productoRepository.delete(productoEncontrado);
		
	}

}
