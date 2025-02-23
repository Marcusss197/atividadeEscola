package app.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty (message = "o nome da Turma é obrigatorio")
	private String nomeTurma;
	private String semestre;
	private long ano;
	private String turno;
	
	@OneToMany
	(mappedBy = "turma")
    private List<Aluno> alunos; 
	
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

	
	@OneToMany
	(mappedBy = "turma")
    private List<Professor> professores; 
	
    @OneToOne
    @JoinColumn(name = "curso_id") // Chave estrangeira na tabela Turma
    private Curso curso;
	
}
