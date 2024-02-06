package ec.edu.espe.examenRodriguez.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmpresaResDto {
    private String ruc;
    private String razonSocial;
    private Date fechaCreacion;

}
