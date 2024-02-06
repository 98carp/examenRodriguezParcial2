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
import java.util.Optional;

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
    public Producto obtenerUnProducto(String codigoProducto){
        Producto producto=this.productoRepository.findByCodigoProducto(codigoProducto).orElseThrow(()->{
            log.error("No existe producto con codigo {}",codigoProducto);
            return new RuntimeException("no existe producto");
        });
        return producto;
    }
    public Producto agregarProducto(ProductoResDto productoResDto){
        try{
           Optional<Producto> producto=this.productoRepository.findByCodigoProducto(productoResDto.getCodigoProducto());
           if(!producto.isPresent()){
               throw new RuntimeException("Error ya existe producto con ese código");
           }
           Producto productoTemp=new Producto();
           productoTemp.setCodigoProducto(productoResDto.getCodigoProducto());
           productoTemp.setDescripcion(productoResDto.getDescripcion());
           productoTemp.setComentarios(productoResDto.getComentarios());
           productoTemp.setPrecio(productoResDto.getPrecio());
           productoTemp.setRucEmpresa(productoResDto.getRucEmpresa());

          return this.productoRepository.save(productoTemp);


        }catch (Exception e){
            throw new RuntimeException("Error al agregar el producto");
        }
    }
    public Producto agregarComentario(Comentario comentario,String codigoProducto){
        try{
          Producto producto=this.productoRepository.findByCodigoProducto(codigoProducto).orElseThrow(()->{
              log.error("No se encuentra el producto con el código {}",codigoProducto);
              return new RuntimeException("Error no se encuentra el producto con ese código");
          });
          List<Comentario>comentarios=producto.getComentarios();
          comentarios.add(comentario);
          producto.setComentarios(comentarios);
          return this.productoRepository.save(producto);

        }catch (Exception e){
            throw new RuntimeException("Error al agregar comentario");
        }
    }


}
