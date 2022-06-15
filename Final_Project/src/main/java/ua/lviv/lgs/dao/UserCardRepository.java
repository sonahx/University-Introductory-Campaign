package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.UserCard;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Integer>{

}
