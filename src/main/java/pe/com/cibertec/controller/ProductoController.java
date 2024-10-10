package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.cibertec.model.CategoriaEntity;
import pe.com.cibertec.model.ProductoEntity;
import pe.com.cibertec.service.CategoriaService;
import pe.com.cibertec.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	//LISTAR PRODUCTO
	@GetMapping("/")
	public String listarProducto(Model model) {
		List<ProductoEntity>listaProducto = productoService.listarProducto();
		model.addAttribute("listaprod", listaProducto);
		return "lista_productos";
	}
	//REGISTRAR PRODUCTO
	@GetMapping("/registrar_producto")
	public String mostrarRegistrarProducto(Model model) {
		List<CategoriaEntity>listaCategoria = categoriaService.listarCategoria();
		model.addAttribute("categorias",listaCategoria);
		model.addAttribute("producto", new ProductoEntity());
		return "registrar_producto";
	}
	
	@PostMapping("/registrar_producto")
	public String registrarProducto(@ModelAttribute("producto") ProductoEntity prod
			, Model model) {
		
		productoService.crearProducto(prod);
		return "redirect:/producto/";
		
	}
	//ACTUALIZAR PRODUCTO
	@GetMapping("/detalle_producto/{id}")
	public String verDetalle(Model model, @PathVariable("id") Integer id) {
		ProductoEntity user = productoService.buscarProductoPorId(id);
		model.addAttribute("user", user);
		return "detalle_producto";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
