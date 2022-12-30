package br.com.alura.springmvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.mudi.model.Pedido;
import br.com.alura.springmvc.mudi.model.StatusPedido;
import br.com.alura.springmvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

//	//action com ModelAndView
//	@GetMapping("/home")
//	public ModelAndView home() {
//		List<Pedido> pedidos = pedidoRepository.findAll();
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("pedidos", pedidos);
//		return mv;
//	}
	
	/*
	 * na literatura e possivel encontrar ambos 
	 * os exemplos de actions
	 */
	@GetMapping
	public String home(Model model, Principal principal, String status) {
		Sort sort = Sort.by("dataEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
