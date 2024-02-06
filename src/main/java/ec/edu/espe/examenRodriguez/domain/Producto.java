package ec.edu.espe.examenRodriguez.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document(collection = "Producto")
public class Producto {

    @Id
    private String codigoProducto;

    private String rucEmpresa;
    private String descripcion;
    private BigDecimal precio;
    private List<Comentario> comentarios;

}
