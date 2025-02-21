package app.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern
	(regexp = "^\\S+\\s+\\S+.*$", message = "O nome do Aluno deve conter ao menos duas palavras separadas.")
	private String nomeAluno;
	
	@CPF
	private String cpf;
	private String telefone;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Turma turma;
	
	private boolean cadastroCompleto;
	
	{
		
	}
	
}
