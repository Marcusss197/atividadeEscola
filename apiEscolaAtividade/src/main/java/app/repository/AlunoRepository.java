package app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public List<Aluno> findByNomeStartingWith(String nome);
	
	public List<Aluno> findByTelefoneContaining(String telefone);
	
	public List<Aluno> findByTurma(String turma);
	
	public Aluno findByCPF(String cpf);
}