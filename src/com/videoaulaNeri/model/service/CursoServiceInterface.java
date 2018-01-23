package com.videoaulaNeri.model.service;

import java.util.List;

import com.videoaulaNeri.model.model.CursoModel;

public interface CursoServiceInterface {
	
	CursoModel salvarCurso(CursoModel curso);

	void alterarCurso(CursoModel curso);
	
	void excluirCurso(CursoModel curso);
	
	List<CursoModel> getCursos();

}
