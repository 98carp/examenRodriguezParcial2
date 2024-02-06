package ec.edu.espe.examenRodriguez.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmpresaDto {
    private String ruc;
    private String razonSocial;
    private String fechaCreacion;

}
