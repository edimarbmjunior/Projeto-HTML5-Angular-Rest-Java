package com.videoaulaNeri.model.service;

import java.util.List;

import com.videoaulaNeri.model.model.ProfessorModel;

public interface ProfessorServiceInterface {
	
	ProfessorModel salvarProfessor(ProfessorModel professor);

	void alterarProfessor(ProfessorModel professor);
	
	void excluirProfessor(ProfessorModel professor);
	
	List<ProfessorModel> getProfessores();

}
