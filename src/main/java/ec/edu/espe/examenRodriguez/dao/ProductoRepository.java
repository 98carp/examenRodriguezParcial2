package ec.edu.espe.examenRodriguez.dao;

import ec.edu.espe.examenRodriguez.domain.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    List<Producto> findAllByRucEmpresa(String rucRmpresa);
    Optional<Producto> findByCodigoProducto(String codigoProducto);
}
