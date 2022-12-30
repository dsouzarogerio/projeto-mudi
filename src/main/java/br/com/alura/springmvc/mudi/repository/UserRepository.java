package br.com.alura.springmvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.mudi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByUsername(String username);

	
}
