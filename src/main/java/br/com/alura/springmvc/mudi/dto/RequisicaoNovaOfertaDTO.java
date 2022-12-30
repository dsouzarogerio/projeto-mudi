package br.com.alura.springmvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.springmvc.mudi.model.Oferta;

public class RequisicaoNovaOfertaDTO {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long pedidoId;

	//regex para valor valido(13265.99 ou 13265)
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	@NotNull
	private String valor;

	//regex para valor valido(11/12/2022)
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataEntrega;
	
	private String comentario;
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatter));
		oferta.setValor(new BigDecimal(this.valor));
		return oferta;
	}
	
}
