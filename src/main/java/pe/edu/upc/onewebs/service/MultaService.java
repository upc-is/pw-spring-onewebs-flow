package pe.edu.upc.onewebs.service;

import java.util.List;

import pe.edu.upc.onewebs.model.entity.Multa;

public interface MultaService extends CrudService<Multa, Integer> {
	List<Multa> fetchByMayorMonto( double monto ) throws Exception;
}
