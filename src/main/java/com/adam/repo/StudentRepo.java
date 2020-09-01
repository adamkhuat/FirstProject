package com.adam.repo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.adam.model.Student;
import com.adam.utils.JPAUtil;

@Named
@SessionScoped
public class StudentRepo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

	public void save(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}

	public Student findById(int id) {
		Student student = new Student();
		student = entityManager.find(Student.class, id);
		return student;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		Query query = entityManager.createQuery("SELECT s FROM Student s");
		list = query.getResultList();
		return list;
	}

	public void edit(Student student) {
		entityManager.getTransaction().begin();
		entityManager.merge(student);
		entityManager.getTransaction().commit();
	}

	public void delete(int id) {
		Student student = new Student();
		student = entityManager.find(Student.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();
	}

}
