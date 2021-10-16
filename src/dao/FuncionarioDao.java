package dao;

import java.util.List;

import model.Funcionario;

public interface FuncionarioDao {
	
	public void salvar (Funcionario funcionario);
	
	public void altera(Funcionario funcionario);
	
	public void remover(String cpf);
	
	public Funcionario pesquisar(String cpf);
	
	public List<Funcionario> listaTodos();

}
