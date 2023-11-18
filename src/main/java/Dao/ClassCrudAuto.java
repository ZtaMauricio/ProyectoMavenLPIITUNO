package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iautoable;
import model.TblAuto;

public class ClassCrudAuto implements Iautoable{

	@Override
	public void RegistrarAuto(TblAuto tblauto) {
	//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//registramos
		emanager.persist(tblauto);
		//emitimos mensaje
		System.out.println("auto registrado en BD");
		//configuramos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}

	
	
	@Override
	public void ActualizarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
				//de persistencia...
				EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
				//gestionar las entidades
				EntityManager emanager = em.createEntityManager();
				//iniciamos la transaccion
				emanager .getTransaction().begin();
				//actualizamos
				emanager.merge(tblauto);
				//emitimos mensaje
				System.out.println("auto actualizado en BD");
				//configuramos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}

	@Override
	public void EliminarAuto(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblAuto elim = emanager.merge(tblauto);
		//eliminar 
		emanager.remove(elim);
		
		//emitimos mensaje
		System.out.println("auto eliminado de la BD");
		//configuramos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public TblAuto Buscar(TblAuto tblauto) {
		//establecemos la conexion con unidad
		//de persistencia...
			EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
			//gestionar las entidades
			EntityManager emanager = em.createEntityManager();
			//iniciamos la transaccion
			emanager .getTransaction().begin();
			//recuperamos el codigo a eliminar
			TblAuto buscar = emanager.find(TblAuto.class,tblauto.getIdauto());
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			return buscar;
	}

	@Override
	public List<TblAuto> Listado() {
		//establecemos la conexion con unidad
		//de persistencia...
		EntityManagerFactory em= Persistence.createEntityManagerFactory("ProyectoMaveLpIITUNO");
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager .getTransaction().begin();
		//Recuperamos el codigo a eliminar
		List<TblAuto> listado = emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
		//configuramos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		return listado;
	}
	
}
