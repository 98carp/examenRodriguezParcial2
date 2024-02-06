package ec.edu.espe.examenRodriguez.service;

import ec.edu.espe.examenRodriguez.dao.ProductoRepository;
import ec.edu.espe.examenRodriguez.domain.Comentario;
import ec.edu.espe.examenRodriguez.domain.Empresa;
import ec.edu.espe.examenRodriguez.domain.Producto;
import ec.edu.espe.examenRodriguez.dto.ProductoResDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    public List<ProductoResDto> obtenerProductosPorEmpresa(String rucEmpresa){
        List<Producto>productos=this.productoRepository.findAllByRucEmpresa(rucEmpresa);

        if(productos.isEmpty()){
            throw new RuntimeException("No existen productos de esa empresa");
        }
        ProductoResDto productoTemp;
        List<ProductoResDto> listaProductosDto=new ArrayList<>();
        for(Producto producto:productos){
            productoTemp= ProductoResDto.builder()
                    .codigoProducto(producto.getCodigoProducto())
                    .rucEmpresa(producto.getRucEmpresa())
                    .comentarios(producto.getComentarios())
                    .descripcion(producto.getDescripcion())
                    .precio(producto.getPrecio())
                    .build();
            listaProductosDto.add(productoTemp);
        }
        return listaProductosDto;
    }
    public void agregarComentario(Comentario comentario,String codigoProducto){
        try{
          Producto producto=this.productoRepository.findByCodigoProducto(codigoProducto).orElseThrow(()->{
              log.error("No se encuentra el producto con el código {}",codigoProducto);
              return new RuntimeException("Error no se encuentra el producto con ese código");
          });
          List<Comentario>comentarios=producto.getComentarios();
          comentarios.add(comentario);
          producto.setComentarios(comentarios);
          this.productoRepository.save(producto);
          
        }catch (Exception e){
            throw new RuntimeException("Error al agregar comentario");
        }
    }

}
