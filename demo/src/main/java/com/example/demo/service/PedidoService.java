package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pedido;
import com.example.demo.domain.PedidoSuplemento;
import com.example.demo.domain.Suplemento;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.PedidoRequestDTO;
import com.example.demo.dto.PedidoResponseDTO;
import com.example.demo.dto.SuplementoRequestDTO;
import com.example.demo.repository.PedidoRepository;

@Service
public class PedidoService extends GenericService<Pedido, Long, PedidoRepository>{
   
    private final SuplementoService suplementoService;

    private final PedidoSuplementoService pedidoSuplementoService;

    private final UsuarioService usuarioService;    
    private final ModelMapper mapper;

    public PedidoService(PedidoRepository repository, SuplementoService suplementoService, PedidoSuplementoService pedidoSuplementoService, ModelMapper mapper, UsuarioService usuarioService) {
        super(repository);
        this.suplementoService = suplementoService;
        this.pedidoSuplementoService = pedidoSuplementoService;
        this.mapper = mapper;
        this.usuarioService = usuarioService;
    }
    
    public Pedido update(PedidoRequestDTO pedidoDTO, Pedido entity, Long id) {
        List<PedidoSuplemento> pedidoSuplementos = new ArrayList<>();
        entity.setTotal(0.0);
        for (int i = 0; i < pedidoDTO.getSuplementos().size(); i++) {
            Suplemento suplementoRequest = pedidoDTO.getSuplementos().get(i);
            Suplemento suplementoEntity = this.suplementoService.findById(suplementoRequest.getId());
        
            if (suplementoEntity.getQuantidade() >= suplementoRequest.getQuantidade()) {
                System.out.println("banco: " + suplementoEntity.getQuantidade());
                System.out.println("request: " + suplementoRequest.getQuantidade());
                suplementoEntity.setQuantidade(suplementoEntity.getQuantidade() - suplementoRequest.getQuantidade());
                
                this.suplementoService.update(suplementoEntity, suplementoEntity.getId());
              
                PedidoSuplemento pedidoSuplemento = new PedidoSuplemento();
                pedidoSuplemento.setPedido(entity);
                pedidoSuplemento.setSuplemento(suplementoRequest);
                pedidoSuplemento.setQtd(suplementoRequest.getQuantidade());
                
                pedidoSuplementos.add(pedidoSuplemento);
        
                entity.setTotal(Math.ceil(entity.getTotal() + (suplementoEntity.getPreco() * suplementoRequest.getQuantidade())));
            }
        }
        System.out.println(entity.getTotal());
        entity.setSuplementos(pedidoSuplementos);
        entity.setId(id);
        return this.update(entity, id);
    }

    public PedidoResponseDTO findById(Long id, PedidoResponseDTO dtoResponse) {
        Pedido pedido = super.findById(id);
        List<PedidoSuplemento> ps = this.pedidoSuplementoService.findByPedidoId(pedido.getId());
        List<SuplementoRequestDTO> suplementos = new ArrayList<>();

        for(int i=0; i < ps.size(); i++){
            SuplementoRequestDTO supDto = mapper.map(ps.get(i).getSuplemento(), SuplementoRequestDTO.class);
            suplementos.add(supDto);
        }

        dtoResponse.setSuplementos(suplementos);
        dtoResponse.addLinks(pedido);
        
        return dtoResponse;
    }
    

    public Pedido create(PedidoRequestDTO pedidoDTO, Pedido pedidoEntity) {
        List<PedidoSuplemento> pedidoSuplementos = new ArrayList<>();
        Usuario usuario = this.usuarioService.findById(pedidoDTO.getCliente().getId());
        pedidoEntity.setTotal(0.0);
        for (int i = 0; i < pedidoDTO.getSuplementos().size(); i++) {
            Suplemento suplementoRequest = pedidoDTO.getSuplementos().get(i);
            Suplemento suplementoEntity = this.suplementoService.findById(suplementoRequest.getId());
        
            if (suplementoEntity.getQuantidade() >= suplementoRequest.getQuantidade()) {
                suplementoEntity.setQuantidade(suplementoEntity.getQuantidade() - suplementoRequest.getQuantidade());
                
                this.suplementoService.update(suplementoEntity, suplementoEntity.getId());
              
                PedidoSuplemento pedidoSuplemento = new PedidoSuplemento();
                pedidoSuplemento.setPedido(pedidoEntity);
                pedidoSuplemento.setSuplemento(suplementoRequest);
                pedidoSuplemento.setQtd(suplementoRequest.getQuantidade());
                
                pedidoSuplementos.add(pedidoSuplemento);
        
                pedidoEntity.setTotal(Math.ceil(pedidoEntity.getTotal() + (suplementoEntity.getPreco() * suplementoRequest.getQuantidade())));
            }
        }

        pedidoEntity.setSuplementos(pedidoSuplementos);
        pedidoEntity.setCliente(usuario);

        // Salva o pedido (e automaticamente as entidades relacionadas devido ao cascade)
        return this.create(pedidoEntity);
    }



    @Override
    public List<Pedido> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
