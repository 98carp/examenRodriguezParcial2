package ec.edu.espe.examenRodriguez.controller;

import ec.edu.espe.examenRodriguez.domain.Empresa;
import ec.edu.espe.examenRodriguez.dto.EmpresaDto;
import ec.edu.espe.examenRodriguez.service.EmpresaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/empresa")
@Slf4j
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{rucEmpresa}")
    public ResponseEntity<EmpresaDto> obtenerEmpresaPorRuc(

          @PathVariable("rucEmpresa")  String rucEmpresa){
        log.info("Obtener Empresa por ruc");
        return ResponseEntity.ok(this.empresaService.obtenerEmpresaPorRuc(rucEmpresa));
    }

    @PostMapping
    public ResponseEntity<Empresa> crearEmpresa(
            @RequestBody EmpresaDto nuevaEmpresa
    ){
        log.info("Se crea empresa");
        return ResponseEntity.ok(this.empresaService.crearEmpresa(nuevaEmpresa));
    }


}
