package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Aluno;
import app.entity.Turma;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public List<Aluno> findByNomeAlunoStartingWith(String nomeAluno);
	
	public List<Aluno> findByTelefoneContaining(String telefone);
	
	public List<Aluno> findByTurma(Turma turma);
	
	public Aluno findByCpf(String cpf);
}