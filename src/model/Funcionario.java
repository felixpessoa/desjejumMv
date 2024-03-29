package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {
	@Id
	private String cpf;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	private Desjejum desjejum;
	
	
	public Funcionario() {
		super();
	}
	public Funcionario(String cpf, String nome, Desjejum desjejum) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.desjejum = desjejum;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Desjejum getDesjejum() {
		return desjejum;
	}
	public void setDesjejum(Desjejum desjejum) {
		this.desjejum = desjejum;
	}
	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", desjejum=" + desjejum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((desjejum == null) ? 0 : desjejum.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (desjejum == null) {
			if (other.desjejum != null)
				return false;
		} else if (!desjejum.equals(other.desjejum))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	

}
