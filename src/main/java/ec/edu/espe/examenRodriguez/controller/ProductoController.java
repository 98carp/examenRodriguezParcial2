package ec.edu.espe.examenRodriguez.controller;

import ec.edu.espe.examenRodriguez.domain.Comentario;
import ec.edu.espe.examenRodriguez.domain.Producto;
import ec.edu.espe.examenRodriguez.dto.ProductoResDto;
import ec.edu.espe.examenRodriguez.service.ProductoService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/codigoProducto")
    public ResponseEntity<Producto> obtenerProducto(
            @PathVariable("codigoProducto") String codigoProducto
    ){
        log.info("Obtener producto por codigo");
        return ResponseEntity.ok(this.productoService.obtenerUnProducto(codigoProducto));
    }
    @GetMapping("/comentarios/codigoProducto")
    public ResponseEntity<List<Comentario>> obtenerComentariosPorProducto(
            @PathVariable("codigoProducto") String codigoProducto
    ){
        log.info("Obtener comentarios por codigo");
        return ResponseEntity.ok(this.productoService.obtenerComentarios(codigoProducto));
    }


    @PostMapping()
    public ResponseEntity<Producto>agregarProducto(
@RequestBody ProductoResDto productoResDto
    ){
        log.info("Agregando producto");
        return ResponseEntity.ok(this.productoService.agregarProducto(productoResDto));
    }

    @PutMapping("/{codigoProducto}")
    public ResponseEntity<Producto> agregarComentario(
            @PathVariable("codigoProducto") String codigoProducto,
            @RequestBody Comentario comentario
            ){
        log.info("Agregando comentario");
        return ResponseEntity.ok(this.productoService.agregarComentario(comentario,codigoProducto));
    }








}
