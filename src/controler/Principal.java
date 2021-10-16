package controler;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.util.JpaUtil;

public class Principal {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.close();
		
//		Desjejum d1 = new Desjejum();
//		d1.setLevar("Pão");
//		
//		DesjejumDaoImpl dao = new DesjejumDaoImpl();
//		dao.salvar(d1);
		
		
		
		
		
	}

}
