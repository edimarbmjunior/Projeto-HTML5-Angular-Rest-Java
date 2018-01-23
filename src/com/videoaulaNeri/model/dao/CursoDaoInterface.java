package com.videoaulaNeri.model.dao;

import java.util.List;

import com.videoaulaNeri.model.model.CursoModel;

public interface CursoDaoInterface {
	CursoModel salvarCurso(CursoModel Curso);

	void alterarCurso(CursoModel Curso);
	
	void excluirCurso(CursoModel Curso);
	
	List<CursoModel> getCursos();
}
