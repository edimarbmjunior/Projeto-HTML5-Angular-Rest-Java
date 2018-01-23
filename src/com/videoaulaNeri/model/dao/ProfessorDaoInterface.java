package com.videoaulaNeri.model.dao;

import java.util.List;

import com.videoaulaNeri.model.model.ProfessorModel;

public interface ProfessorDaoInterface {
	ProfessorModel salvarProfessor(ProfessorModel professor);

	void alterarProfessor(ProfessorModel professor);
	
	void excluirProfessor(ProfessorModel professor);
	
	List<ProfessorModel> getProfessores();
}
