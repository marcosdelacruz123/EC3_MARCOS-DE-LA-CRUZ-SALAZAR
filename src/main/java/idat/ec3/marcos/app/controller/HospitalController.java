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

import idat.ec3.marcos.app.model.Hospital;
import idat.ec3.marcos.app.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {


	@Autowired
	private HospitalService service;
	
	
	@RequestMapping(path= "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Hospital>> listar(){
		List<Hospital> listahospitales = service.listar();
		return new ResponseEntity<List<Hospital>>(listahospitales,HttpStatus.OK);
		
	}

	@RequestMapping(path= "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>buscarporid(@PathVariable Integer id){
		Hospital hospital = service.obtener(id);
		if (hospital!= null) {
			return new ResponseEntity<>(hospital,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(hospital,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> registrar(@RequestBody Hospital hospital){
		service.guardar(hospital);
		return new ResponseEntity<>(hospital,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Hospital h,@PathVariable Integer id){
		Hospital hospital = service.obtener(h.getIdHospital());
		if (hospital!= null) {
			service.actualizar(hospital);
			return new ResponseEntity<>(hospital,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(hospital,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Hospital hospital = service.obtener(id);
		if (hospital!= null) {
			service.eliminar(id);
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(id,HttpStatus.NOT_FOUND);
		}
	}
	
}
