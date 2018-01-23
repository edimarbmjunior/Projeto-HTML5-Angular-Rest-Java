package com.videoaulaNeri.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.videoaulaNeri.model.dao.CursoDaoInterface;
import com.videoaulaNeri.model.model.CursoModel;

public class CursoServiceImplement implements CursoServiceInterface{

	@Inject
	private CursoDaoInterface cursoDaoInterface;

	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel curso) {
		return cursoDaoInterface.salvarCurso(curso);
	}

	@Override
	@Transactional
	public void alterarCurso(CursoModel curso) {
		cursoDaoInterface.alterarCurso(curso);;
	}

	@Override
	@Transactional
	public void excluirCurso(CursoModel curso) {
		cursoDaoInterface.excluirCurso(curso);
	}

	@Override
	@Transactional
	public List<CursoModel> getCursos() {
		return cursoDaoInterface.getCursos();
	}

}
