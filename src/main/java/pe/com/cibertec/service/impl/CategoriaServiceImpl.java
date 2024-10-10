package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.model.CategoriaEntity;
import pe.com.cibertec.repository.CategoriaRepository;
import pe.com.cibertec.service.CategoriaService;
@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Override
	public List<CategoriaEntity> listarCategoria() {
		
		return categoriaRepository.findAll();
	}

}
