package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	
	public String save(Turma turma) {
		this.turmaRepository.save(turma); 
		return "Turma salva com sucesso";
	}
	

	public String update(long id, Turma turma) {
		turma.setId(id);
		this.turmaRepository.save(turma); 
		return "Turma foi atualizada com sucesso";
	}
	
	public String delete(long id) {
		this.turmaRepository.deleteById(id);
		return "Turma dissolvida com sucesso";
	}
	
	public Turma findById(long id) {
		return this.turmaRepository.findById(id).get();
	}
	
	public List<Turma> findAll(){
		return this.turmaRepository.findAll();
	}
	
	public List<Turma> findByAnoBetween(int anoInicio, int anoFim) {
        return turmaRepository.findByAnoBetween(anoInicio, anoFim);
    }

    public List<Turma> findBySemestreAndAno(String semestre, int ano) {
        return turmaRepository.findBySemestreAndAno(semestre, ano);
    }

    public List<Turma> findByNomeETurno(String nomeTurma, String turno) {
        return turmaRepository.findByNomeETurno(nomeTurma,turno);
    }

    public List<Turma> findByNomeCurso(String curso) {
        return turmaRepository.findByNomeCurso(curso);
    }

}