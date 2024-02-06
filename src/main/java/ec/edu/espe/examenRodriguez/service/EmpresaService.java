package ec.edu.espe.examenRodriguez.service;

import ec.edu.espe.examenRodriguez.dao.EmpresaRepository;
import ec.edu.espe.examenRodriguez.domain.Empresa;
import ec.edu.espe.examenRodriguez.dto.EmpresaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaDto obtenerEmpresaPorRuc(String rucEmpresa){
        Empresa empresa=this.empresaRepository.findByRuc(rucEmpresa).orElseThrow(
                () -> {
                    log.error("Empresa con el ruc {} no encontrado", rucEmpresa);
                    return new RuntimeException();
                });
        EmpresaDto empresaDto = EmpresaDto.builder()
                .ruc(empresa.getRuc())
                .fechaCreacion(empresa.getFechaCreacion())
                .fechaCreacion(empresa.getFechaCreacion())
                .razonSocial(empresa.getRazonSocial())
                .build();

        return empresaDto;
    }

    public void crearEmpresa(EmpresaDto nuevaEmpresa)
    {
        try{
            Optional<Empresa> empresaTemp=this.empresaRepository.findByRuc(nuevaEmpresa.getRuc());
            if(empresaTemp.isPresent()){
                log.error("Empresa con el ruc {} ya existe", nuevaEmpresa.getRuc());
                throw new RuntimeException("Empresa ya existe");
            }
            Empresa empresa=new Empresa();
            empresa.setRuc(nuevaEmpresa.getRuc());
            empresa.setFechaCreacion(nuevaEmpresa.getFechaCreacion());
            empresa.setRazonSocial(nuevaEmpresa.getRazonSocial());
            this.empresaRepository.save(empresa);
            log.info("Se creo la empresa: ", empresa);
        }catch (Exception e){
            throw new RuntimeException("Error al crear empresa");
        }

    }
}
