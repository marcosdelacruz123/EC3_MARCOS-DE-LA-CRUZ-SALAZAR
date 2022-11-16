package idat.ec3.marcos.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.ec3.marcos.app.model.UsuarioCliente;
import idat.ec3.marcos.app.repository.UsuarioRepository;
@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {

	@Autowired
	private UsuarioRepository repositorio;
	
	@Override
	public void guardar(UsuarioCliente cliente) {
		repositorio.save(cliente);
		
	}

	@Override
	public void actualizar(UsuarioCliente cliente) {
		repositorio.saveAndFlush(cliente);
		
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<UsuarioCliente> listar() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioCliente obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}


}
