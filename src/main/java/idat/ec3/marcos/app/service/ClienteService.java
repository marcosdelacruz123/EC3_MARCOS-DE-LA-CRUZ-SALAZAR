package idat.ec3.marcos.app.service;

import java.util.List;

import idat.ec3.marcos.app.model.Cliente;

public interface ClienteService {

	void guardar(Cliente cliente);
	void actualizar(Cliente cliente);
	void eliminar(Integer id);
	List<Cliente> listar();
	Cliente obtener(Integer id);
}
