package idat.ec3.marcos.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.ec3.marcos.app.model.UsuarioCliente;
import idat.ec3.marcos.app.service.UsuarioClienteService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


	@Autowired
	private UsuarioClienteService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioCliente>> listar(){
		List<UsuarioCliente> listausuarios = service.listar();
		return new ResponseEntity<List<UsuarioCliente>>(listausuarios,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		UsuarioCliente usuarioCliente = service.obtener(id);
		if (usuarioCliente!= null) {
			return new ResponseEntity<>(usuarioCliente,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(usuarioCliente,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody UsuarioCliente usuarioCliente){
		service.guardar(usuarioCliente);
		return new ResponseEntity<>(usuarioCliente,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody UsuarioCliente u,@PathVariable Integer id){
		UsuarioCliente usuarioCliente = service.obtener(u.getIdUsuario());
		if (usuarioCliente!= null) {
			service.actualizar(usuarioCliente);
			return new ResponseEntity<>(usuarioCliente,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(usuarioCliente,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		UsuarioCliente usuarioCliente = service.obtener(id);
		if (usuarioCliente!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
