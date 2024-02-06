package ec.edu.espe.examenRodriguez.controller;

import ec.edu.espe.examenRodriguez.dto.ProductoResDto;
import ec.edu.espe.examenRodriguez.service.ProductoService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/producto")
@Slf4j
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/lista/{rucEmpresa}")
    public ResponseEntity<List<ProductoResDto>>
        obtenerProductosPorEmpresa(
                @PathParam("rucEmpresa")
                String rucEmpresa){
        log.info("Obteniendo listado de productos");
        return ResponseEntity.ok(this.productoService.obtenerProductosPorEmpresa(rucEmpresa));

    }

    



}
