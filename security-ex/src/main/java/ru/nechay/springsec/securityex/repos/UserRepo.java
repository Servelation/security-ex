package ru.nechay.springsec.securityex.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.nechay.springsec.securityex.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
}
