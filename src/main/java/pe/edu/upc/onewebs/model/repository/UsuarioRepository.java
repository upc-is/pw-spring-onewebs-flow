package pe.edu.upc.onewebs.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.onewebs.model.entity.Detenido;
import pe.edu.upc.onewebs.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	List<Usuario> findByUsername( String username ) throws Exception;
}
