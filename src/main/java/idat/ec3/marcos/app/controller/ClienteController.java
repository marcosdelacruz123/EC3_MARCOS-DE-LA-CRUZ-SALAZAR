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

import idat.ec3.marcos.app.model.Cliente;
import idat.ec3.marcos.app.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


	@Autowired
	private ClienteService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> listaclientes = service.listar();
		return new ResponseEntity<List<Cliente>>(listaclientes,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Cliente cliente = service.obtener(id);
		if (cliente!= null) {
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(cliente,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody Cliente cliente){
		service.guardar(cliente);
		return new ResponseEntity<>(cliente,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Cliente c,@PathVariable Integer id){
		//producto.setId_producto(id);

		Cliente cliente = service.obtener(c.getIdCliente());
		if (cliente!= null) {
			service.actualizar(cliente);
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(cliente,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Cliente cliente = service.obtener(id);
		if (cliente!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
