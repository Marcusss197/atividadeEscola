package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public String save(Aluno aluno) {
		Aluno prop = this.alunoRepository.findByCPF(aluno.getCpf());
		if(prop != null) {
			throw new RuntimeException("Já existe um aluno com o CPF inserido");
		}
		
		if(aluno.getTelefone() == null) {
			aluno.setCadastroCompleto(false);
		}else {
			aluno.setCadastroCompleto(true);
		}
		
		if (aluno.isCadastroCompleto() == true) {
			this.alunoRepository.save(aluno); 
			return "Aluno salvo com sucesso";
			} else {
				throw new RuntimeException("Cadastro está incompleto");
			}
	}
	

	public String update(long id, Aluno aluno) {
		aluno.setId(id);
		
		if(aluno.getTelefone() == null) {
			aluno.setCadastroCompleto(false);
		}else {
			aluno.setCadastroCompleto(true);
		}
		
		if (aluno.isCadastroCompleto() == true) {
			this.alunoRepository.save(aluno); 
			return "Aluno salvo com sucesso";
			} else {
				throw new RuntimeException("Cadastro está incompleto");
			}
	} 
	
	public String delete(long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno deletado com sucesso";
	}
	
	public Aluno findById(long id) {
		return this.alunoRepository.findById(id).get();
	}
	
	public List<Aluno> findAll(){
		return this.alunoRepository.findAll();
	}
	
	public List<Aluno> findByNome(String nome){
		return this.alunoRepository.findByNomeStartingWith(nome);
	}
	
	public List<Aluno> findByTelefone(String telefone){
		return this.alunoRepository.findByTelefoneContaining(telefone);
	}

	
}