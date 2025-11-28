package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dit.model.Category;

public class CategoryDAO {


	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("GreenHouse");

			public CategoryDAO() {
				// TODO Auto-generated constructor stub
			}

			public void persist(Category category) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(category);
				em.getTransaction().commit();
				em.close();
			}
			
			public void removeCategory(Category category) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.remove(em.merge(category));
				em.getTransaction().commit();
				em.close();
			}
			
			public Category merge(Category category) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
			    Category updatedCategory = em.merge(category);
				em.getTransaction().commit();
				em.close();
				return updatedCategory;
			}
			
			
			public List<Category> getAllCategorys() {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				List<Category> categorys = new ArrayList<Category>();
				categorys = em.createQuery("from Category").getResultList();
				em.getTransaction().commit();
				em.close();
				return categorys;
			}

			public Category getCategoryByCode(String code ) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Category c = em.createQuery("SELECT c FROM User u WHERE c.code = :code", Category.class)
		                .setParameter("code", code)
		                .getSingleResult();
				em.getTransaction().commit();
				em.close();
				return c;
			}
	
	
	
	
	
	
	
