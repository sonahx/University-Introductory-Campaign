package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.UserApplication;

@Repository
public interface UserApplicationRepository extends JpaRepository<UserApplication, Integer>{

}
