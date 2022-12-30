package br.com.alura.springmvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.mudi.interceptor.InterceptadorDeAcessos;
import br.com.alura.springmvc.mudi.interceptor.model.Acesso;

@RestController
@RequestMapping("api/acessos")
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcessos.acessos;
	}

}
