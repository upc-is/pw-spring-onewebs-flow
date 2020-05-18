package pe.edu.upc.onewebs.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.onewebs.model.entity.Detenido;

public interface DetenidoRepository extends JpaRepository<Detenido, Integer> {
	Optional<Detenido> findByDni(String dni) throws Exception;
	List<Detenido> findByApellidos( String apellidos ) throws Exception;
	List<Detenido> findByNombres( String nombres ) throws Exception;
	List<Detenido> findByDistrito( String distrito ) throws Exception;
}
