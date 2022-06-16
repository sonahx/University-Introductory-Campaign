package ua.lviv.lgs.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
}
