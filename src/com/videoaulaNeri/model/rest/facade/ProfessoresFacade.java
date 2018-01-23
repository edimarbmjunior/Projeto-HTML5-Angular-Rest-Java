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

import com.videoaulaNeri.model.model.ProfessorModel;
import com.videoaulaNeri.model.service.ProfessorServiceInterface;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessoresFacade {
	
	//direto, sem uso de serviço
	/*@Inject
	private ProfessorDaoImplemenInterface professorDaoImplemenInterface;
	
	@GET
	public List<ProfessorModel> getProfessores(){
		return professorDaoImplemenInterface.getProfessores();
	}*/
	
	@Inject
	private ProfessorServiceInterface professorServiceInterface;
	
	@GET
	public List<ProfessorModel> getProfessor(){
		return professorServiceInterface.getProfessores();
	}
	
	@POST
	public ProfessorModel salvarProfessor(ProfessorModel professor) {
		return professorServiceInterface.salvarProfessor(professor);
	}
	
	@PUT
	public void atualizarProfessor(ProfessorModel professor) {
		professorServiceInterface.alterarProfessor(professor);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void excluirProfessor(@PathParam("codigoProfessor") Integer codigoProfessor) {
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setCodigo(codigoProfessor);
		professorServiceInterface.excluirProfessor(professorModel);
	}
}
