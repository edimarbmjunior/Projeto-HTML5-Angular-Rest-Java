package com.videoaulaNeri.model.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="professor")
public class ProfessorModel implements Serializable{

	private static final long serialVersionUID = 2891295991694794703L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prof_codigo")
	private Integer codigo;
	
	@Column(name="prof_nome", length=50, nullable=false)
	private String nome;

	@Column(name="prof_email", length=50, nullable=true)
	private String email;
	
	@Column(name="prof_fone", length=15, nullable=false)
	private String fone;

	public ProfessorModel() {
		// TODO Auto-generated constructor stub
	}

	public ProfessorModel(Integer codigo, String nome, String email, String fone) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorModel other = (ProfessorModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
}
