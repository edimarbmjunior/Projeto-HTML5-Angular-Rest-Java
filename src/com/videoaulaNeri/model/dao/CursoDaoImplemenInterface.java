package com.videoaulaNeri.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.videoaulaNeri.model.model.CursoModel;

public class CursoDaoImplemenInterface implements CursoDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;

	@Override
	public CursoModel salvarCurso(CursoModel curso) {
		entityManager.persist(curso);
		return curso;
	}

	@Override
	public void alterarCurso(CursoModel curso) {
		CursoModel cursoModelMerger = entityManager.merge(curso);
		entityManager.persist(cursoModelMerger);
	}

	@Override
	public void excluirCurso(CursoModel curso) {
		CursoModel cursoModelMerger = entityManager.merge(curso);
		entityManager.remove(cursoModelMerger);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CursoModel> getCursos() {
		Query query = entityManager.createQuery("from CursoModel");
		return query.getResultList();
	}
}