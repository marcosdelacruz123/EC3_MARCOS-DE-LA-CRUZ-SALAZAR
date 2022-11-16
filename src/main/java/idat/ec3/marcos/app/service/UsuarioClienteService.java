package idat.ec3.marcos.app.service;

import java.util.List;
import idat.ec3.marcos.app.model.UsuarioCliente;

public interface UsuarioClienteService {

	void guardar(UsuarioCliente usuarioCliente);
	void actualizar(UsuarioCliente usuarioCliente);
	void eliminar(Integer id);
	List<UsuarioCliente> listar();
	UsuarioCliente obtener(Integer id);
}
