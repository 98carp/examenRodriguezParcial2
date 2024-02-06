package ec.edu.espe.examenRodriguez.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@NoArgsConstructor
public class Comentario {
    private BigDecimal calificacion;
    private String comentario;
    private String usuario;
    private String fechaComentario;
}
