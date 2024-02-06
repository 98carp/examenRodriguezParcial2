package ec.edu.espe.examenRodriguez.dao;

import ec.edu.espe.examenRodriguez.domain.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<Empresa,String> {
}
