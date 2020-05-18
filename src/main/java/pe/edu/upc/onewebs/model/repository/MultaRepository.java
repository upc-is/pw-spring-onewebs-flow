package pe.edu.upc.onewebs.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.onewebs.model.entity.Multa;

public interface MultaRepository extends JpaRepository<Multa, Integer> {
	@Query("SELECT m FROM Multa m WHERE m.monto > :monto")
	List<Multa> fetchByMayorMonto( double monto ) throws Exception;	
}
