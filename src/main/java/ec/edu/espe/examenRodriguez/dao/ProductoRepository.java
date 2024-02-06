package ec.edu.espe.examenRodriguez.dao;

import ec.edu.espe.examenRodriguez.domain.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<String, Producto> {
}
