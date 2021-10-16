package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.DesjejumDao;
import model.Desjejum;
import model.Funcionario;
import model.util.JpaUtil;

public class DesjejumDaoImpl implements DesjejumDao {
	
	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Desjejum desjejum) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(desjejum);
			et.commit();
		}	catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de transação");
		}	finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void altera(Desjejum desjejum) {
		try {
			this.em =JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.merge(desjejum);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("erro de transação");
		}	finally {
			if(em.isOpen()) {
				em.close();
			}
		}
		
	}

	@Override
	public void remover(int id_levar) {
		try{
			this.em = JpaUtil.getEntityManager();
			et.begin();
			em.remove(em.find(Desjejum.class, id_levar));
			et.commit();
		}	catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de trasação");
		}	finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Desjejum pesquisar(int id_levar) {
		Desjejum desjejum = new Desjejum();
		try {
			this.em = JpaUtil.getEntityManager();
			desjejum = em.find(Desjejum.class, id_levar);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro de trasação");
		}	finally {
			if (em.isOpen()){
			   em.close();
			}
		}
		return desjejum;
	}

	@Override
	public List<Desjejum> listaTodos() {
		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Desjejum e");
		List<Desjejum> listaDesjejum = query.getResultList();
		em.close();
		return listaDesjejum;
	}

}
