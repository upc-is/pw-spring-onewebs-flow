package pe.edu.upc.onewebs.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.onewebs.model.entity.Comisaria;

public interface ComisariaRepository extends JpaRepository<Comisaria, Integer> {
	List<Comisaria> findByDistrito( String distrito ) throws Exception;
}
