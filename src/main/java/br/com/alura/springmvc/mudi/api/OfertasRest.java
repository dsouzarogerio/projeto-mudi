package br.com.alura.springmvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.mudi.dto.RequisicaoNovaOfertaDTO;
import br.com.alura.springmvc.mudi.model.Oferta;
import br.com.alura.springmvc.mudi.model.Pedido;
import br.com.alura.springmvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	

	@PostMapping
	public ResponseEntity<Oferta> criaOferta(@Valid @RequestBody RequisicaoNovaOfertaDTO requisicao) {
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Oferta novaOferta = requisicao.toOferta();
		Pedido pedido = pedidoBuscado.get();
		novaOferta.setPedido(pedido);
		pedido.getOfertas().add(novaOferta);
		pedidoRepository.save(pedido);
		
		return ResponseEntity.ok(novaOferta);
		
	}

}
