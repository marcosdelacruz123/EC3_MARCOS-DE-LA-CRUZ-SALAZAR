package idat.ec3.marcos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.ec3.marcos.app.model.UsuarioCliente;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioCliente, Integer> {
	
	UsuarioCliente findByUsuario(String usuario);
	
}
