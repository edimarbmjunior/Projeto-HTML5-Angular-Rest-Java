package com.videoaulaNeri.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.videoaulaNeri.model.dao.ProfessorDaoInterface;
import com.videoaulaNeri.model.model.ProfessorModel;

public class ProfessorServiceImplement implements ProfessorServiceInterface{

	@Inject
	private ProfessorDaoInterface professorDaoInterface;

	@Override
	@Transactional
	public ProfessorModel salvarProfessor(ProfessorModel professor) {
		return professorDaoInterface.salvarProfessor(professor);
	}

	@Override
	@Transactional
	public void alterarProfessor(ProfessorModel professor) {
		professorDaoInterface.alterarProfessor(professor);;
	}

	@Override
	@Transactional
	public void excluirProfessor(ProfessorModel professor) {
		professorDaoInterface.excluirProfessor(professor);
	}

	@Override
	@Transactional
	public List<ProfessorModel> getProfessores() {
		return professorDaoInterface.getProfessores();
	}

}
