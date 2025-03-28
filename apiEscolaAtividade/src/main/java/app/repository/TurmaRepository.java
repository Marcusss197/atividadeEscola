package app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	public List<Turma> findByAnoBetween(int anoInicio, int anoFim);
	
	public List<Turma> findBySemestreAndAno(String semestre, int ano);
	
	public List<Turma> findByNomeTurmaAndTurno(String nomeTurma, String turno);
	
	public List<Turma> findByCursoNomeCurso(String curso);
	
}