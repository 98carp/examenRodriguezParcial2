package ec.edu.espe.examenRodriguez.dao;

import ec.edu.espe.examenRodriguez.domain.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmpresaRepository extends MongoRepository<Empresa,String> {
    Optional<Empresa> findByRuc(String rucEmpresa);
}
