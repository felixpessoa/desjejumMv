package dao;

import java.util.List;

import model.Desjejum;

public interface DesjejumDao {
	public void salvar(Desjejum desjejum);
	
	public void altera(Desjejum desjejum);
	
	public void remover(int id_levar);
	
	public Desjejum pesquisar(int id_levar);
	
	public List<Desjejum> listaTodos();

}
