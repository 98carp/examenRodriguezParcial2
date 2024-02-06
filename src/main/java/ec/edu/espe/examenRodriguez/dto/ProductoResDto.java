package ec.edu.espe.examenRodriguez.dto;

import ec.edu.espe.examenRodriguez.domain.Comentario;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductoResDto {

    private String codigoProducto;
    private String rucEmpresa;
    private String descripcion;
    private BigDecimal precio;
    private List<Comentario> comentarios;
}
