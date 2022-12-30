package br.com.alura.springmvc.mudi.interceptor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.mudi.interceptor.model.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long>  {

}
