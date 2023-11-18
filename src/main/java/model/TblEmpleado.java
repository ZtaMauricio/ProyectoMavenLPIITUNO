package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_empleado database table.
 * 
 */
@Entity
@Table(name="tbl_empleado")
@NamedQuery(name="TblEmpleado.findAll", query="SELECT t FROM TblEmpleado t")
public class TblEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idedempleado;

	private String apellido;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fechanac;

	private String nombre;

	private String sexo;

	public TblEmpleado() {
	}

	public int getIdedempleado() {
		return this.idedempleado;
	}

	public void setIdedempleado(int idedempleado) {
		this.idedempleado = idedempleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}