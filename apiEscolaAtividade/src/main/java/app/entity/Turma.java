package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
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
	private Curso curso;
	
    @ManyToMany
    @JoinTable(name="turma_professor")
    private List<Professor> professores;
	
}
