package br.com.alura.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.mudi.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);
}
