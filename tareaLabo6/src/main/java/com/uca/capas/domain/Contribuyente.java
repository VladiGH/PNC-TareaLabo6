package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name ="contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoContribuyente;
	
	@Size(max = 30,message="El nombre no debe tener mas de 30 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
	@Column(name="s_nombre")
	private String nombre;
	
	@Size(max = 30,message="El nombre no debe tener mas de 30 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
	@Column(name="s_apellido")
	private String apellido;
	
	@Size(max = 14,message="El nombre no debe tener mas de 14 caracteres")
	@NotEmpty(message="Este campo no puede quedar vacio")
	@Column(name="s_nit")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fechaIngreso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;
	
	public Contribuyente() {
		
	}

	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}

	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	};

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
}
