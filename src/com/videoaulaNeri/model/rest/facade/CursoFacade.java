package com.videoaulaNeri.model.rest.facade;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.videoaulaNeri.model.model.CursoModel;
import com.videoaulaNeri.model.service.CursoServiceInterface;

@Path("/cursos")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class CursoFacade {
	
	@Inject
	private CursoServiceInterface cursoServiceInterface;

	@GET
	public List<CursoModel> getcursos(){
		return cursoServiceInterface.getCursos();
	}
	
	@POST
	public CursoModel salvar(CursoModel cursoModel) {
		return cursoServiceInterface.salvarCurso(cursoModel);
	}
	
	@PUT
	public void atualizar(CursoModel cursoModel) {
		cursoServiceInterface.alterarCurso(cursoModel);
	}
	
	@DELETE
	@Path("/{codigoCurso}")
	public void delete(@PathParam("codigoCurso") Integer codigoCurso) {
		CursoModel curso = new CursoModel();
		curso.setCodigo(codigoCurso);
		cursoServiceInterface.excluirCurso(curso);
	}
}
