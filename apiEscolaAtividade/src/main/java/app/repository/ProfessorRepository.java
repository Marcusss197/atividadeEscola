package app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Aluno;
import app.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	public List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade);
	
	public List<Professor> findByEmailNotContaining(String email);  
	
	public List<Professor> findByEmail(String email);  
	
}