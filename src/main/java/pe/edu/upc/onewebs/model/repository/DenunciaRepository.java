package pe.edu.upc.onewebs.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.onewebs.model.entity.Denuncia;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

}
