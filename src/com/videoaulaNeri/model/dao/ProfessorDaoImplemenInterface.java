package com.videoaulaNeri.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.videoaulaNeri.model.model.ProfessorModel;

public class ProfessorDaoImplemenInterface implements ProfessorDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;

	@Override
	public ProfessorModel salvarProfessor(ProfessorModel professor) {
		entityManager.persist(professor);
		return professor;
	}

	@Override
	public void alterarProfessor(ProfessorModel professor) {
		ProfessorModel professorModelMerger = entityManager.merge(professor);
		entityManager.persist(professorModelMerger);
	}

	@Override
	public void excluirProfessor(ProfessorModel professor) {
		ProfessorModel professorModelMerger = entityManager.merge(professor);
		entityManager.remove(professorModelMerger);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProfessorModel> getProfessores() {
		Query query = entityManager.createQuery("from ProfessorModel");
		return query.getResultList();
	}
}
