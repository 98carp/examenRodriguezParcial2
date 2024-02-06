package ec.edu.espe.examenRodriguez.service;

import ec.edu.espe.examenRodriguez.dao.EmpresaRepository;
import ec.edu.espe.examenRodriguez.domain.Empresa;
import ec.edu.espe.examenRodriguez.dto.EmpresaResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaResDto obtenerEmpresaPorRuc(String rucEmpresa){
        Empresa empresa=this.empresaRepository.findByRuc(rucEmpresa).orElseThrow(
                () -> {
                    log.error("Empresa con el ruc {} no encontrado", rucEmpresa);
                    return new RuntimeException();
                });
        EmpresaResDto empresaResDto= EmpresaResDto.builder()
                .ruc(empresa.getRuc())
                .fechaCreacion(empresa.getFechaCreacion())
                .fechaCreacion(empresa.getFechaCreacion())
                .razonSocial(empresa.getRazonSocial())
                .build();
        return empresaResDto;
    }
    
}
