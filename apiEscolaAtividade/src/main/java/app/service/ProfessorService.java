package app.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	
	public String save(Professor professor) {
		
		if (professor.getCpf().contains("@outlook.com"))
			throw new RuntimeException("Nn pode outlook po");
		
		this.professorRepository.save(professor); 
		return "Professor salvo com sucesso";
	}
	

	public String update(long id, Professor professor) {
		professor.setId(id);
		this.professorRepository.save(professor); //-> qdo tem ID vira UPDATE livro SET ....
		return "Informações do aluno salvo com sucesso";
	} 
	
	public String delete(long id) {
		this.professorRepository.deleteById(id);
		return "Professor demitido com sucesso";
	}
	
	public Professor findById(long id) {
		return this.professorRepository.findById(id).get();
	}
	
	public List<Professor> findAll(){
		return this.professorRepository.findAll();
	}

}