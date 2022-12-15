package br.com.alura.springmvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.springmvc.mudi.model.Pedido;
import br.com.alura.springmvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	/*
	 * na literatura e possivel encontrar ambos 
	 * os exemplos de actions
	 */
//	@GetMapping("/home")
//	public String home(Model model) {
//		List<Pedido> pedidos = pedidoRepository.findAll();
//		model.addAttribute("pedidos", pedidos);
//		return "home";
//	}
	
	//action com ModelAndView
	@GetMapping("/home")
	public ModelAndView home() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("pedidos", pedidos);
		return mv;
	}
}
