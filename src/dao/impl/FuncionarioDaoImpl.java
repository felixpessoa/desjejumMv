package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.FuncionarioDao;
import model.Funcionario;
import model.util.JpaUtil;

public class FuncionarioDaoImpl implements FuncionarioDao{
	private EntityManager em;
	private EntityTransaction et;
	
	
	@Override
	public void salvar(Funcionario funcionario) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(funcionario);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de transmição");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public void altera(Funcionario funcionario) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(funcionario);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de trasação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void remover(String cpf) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Funcionario.class, cpf));
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de trasação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public Funcionario pesquisar(String cpf) {
		Funcionario funcionario = new Funcionario();
		try {
			this.em = JpaUtil.getEntityManager();
			funcionario = em.find(Funcionario.class, cpf);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.print("Erro trasacão");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return funcionario;
	}

	@Override
	public List<Funcionario> listaTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Funcionario e");
		List<Funcionario> listaFuncionario = query.getResultList();
		em.close();
		return listaFuncionario;
	}

}
