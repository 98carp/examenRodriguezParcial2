package ec.edu.espe.examenRodriguez.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Empresa")
public class Empresa {
    @Id
    private String idEmpresa;
    @Indexed(unique = true)
    private String ruc;
    private String razonSocial;
    private Date fechaCreacion;


}
