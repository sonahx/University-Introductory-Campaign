package ua.lviv.lgs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
	
}
