package br.com.alura.mudi.service;

import org.springframework.stereotype.Service;

import br.com.alura.mudi.model.User;
import br.com.alura.mudi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
