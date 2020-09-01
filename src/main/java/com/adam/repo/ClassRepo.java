package com.adam.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.adam.model.StudentClass;
import com.adam.utils.JPAUtil;

public class ClassRepo {

	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void save(StudentClass sclass) {
		entityManager.getTransaction().begin();
		entityManager.persist(sclass);
		entityManager.getTransaction().commit();
//		JPAUtil.shutdown();
	}

	public void edit(StudentClass sclass) {
		entityManager.getTransaction().begin();
		entityManager.merge(sclass);
		entityManager.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	public StudentClass findById(int id) {
		StudentClass studentClass = new StudentClass();
		studentClass = entityManager.find(StudentClass.class, id);
//		JPAUtil.shutdown();
		return studentClass;
	}

	@SuppressWarnings("unchecked")
	public List<StudentClass> getAllStudents() {
		List<StudentClass> list = new ArrayList<StudentClass>();
		Query query = entityManager.createQuery("SELECT c FROM StudentClass c");
		list = query.getResultList();
		return list;
	}

	public void delete(int id) {
		StudentClass studentClass = new StudentClass();
		studentClass = entityManager.find(StudentClass.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(studentClass);
		entityManager.getTransaction().commit();
	}

}
