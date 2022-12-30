package br.com.alura.springmvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.alura.springmvc.mudi.interceptor.model.Acesso;
import br.com.alura.springmvc.mudi.interceptor.repository.AcessoRepository;

@SuppressWarnings("deprecation")
public class InterceptadorDeAcessos extends HandlerInterceptorAdapter{
	
	@Autowired
	private AcessoRepository acessoRepository;
	
	public static final List<Acesso> acessos = new ArrayList<Acesso>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Acesso acesso = new Acesso();
		acesso.setPath(request.getRequestURI());
		acesso.setData(LocalDateTime.now());
		
		request.setAttribute("acesso", acesso);
		
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		Acesso acesso = (Acesso) request.getAttribute("acesso");
		acesso.setDuracao(Duration.between(acesso.getData(), LocalDateTime.now()));
		acessos.add(acesso);
		
		/**
		 * implementar no banco de dados esta com exception
		 * HandlerInterceptor.afterCompletion threw exception
		 */
//		acessoRepository.save(acesso);
	}

}
