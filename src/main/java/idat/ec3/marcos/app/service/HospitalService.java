package idat.ec3.marcos.app.service;

import java.util.List;

import idat.ec3.marcos.app.model.Hospital;

public interface HospitalService {

	void guardar(Hospital hospital);
	void actualizar(Hospital hospital);
	void eliminar(Integer id);
	List<Hospital> listar();
	Hospital obtener(Integer id);
}
