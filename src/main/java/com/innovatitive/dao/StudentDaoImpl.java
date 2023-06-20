package com.innovatitive.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.innovatitive.model.Innovativestudents;
import com.innovatitive.utils.HibernateUtils;

public class StudentDaoImpl implements StudentDao {

//	save student
//	update student
//	find by
//	id delete
//	student
//	find ByAll

//	@Override
//	public void save(Innovativestudents invStudent) {
//		Transaction transaction = null;
//
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//			// transaction started
//			transaction = session.beginTransaction();
//			// save the object
//			session.save(invStudent);
//			// commit the transaction
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//		}
//
//	}

	SessionFactory sessionFactory = new Configuration().configure("com/innovatitive/config/Hibernate.cfg.xml")
			.buildSessionFactory();

	@Override
	public void save(Innovativestudents invStudent) {
		Transaction transaction = null;

		try (Session session = sessionFactory.openSession()) {
			System.out.println(sessionFactory);// here we are checking session object is creating and opening or not
			// save the object
			session.save(invStudent);
			// transaction started
			transaction = session.beginTransaction();

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void update(Innovativestudents invStudent) {
		Transaction transaction = null;

//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
		try (Session session = sessionFactory.openSession()) {

			// update the object
			session.saveOrUpdate(invStudent);
			
			// transaction started
			transaction = session.beginTransaction();

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}

	}

	@Override
	public Innovativestudents findById(long invID) {
		Transaction transaction = null;

		Innovativestudents studentid = null;
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
		try (Session session = sessionFactory.openSession()) {
			
			
//			get()method the student Object
//			get() loads the data as soon as it's called 
			studentid = session.get(Innovativestudents.class, invID);
			
			// transaction begin
			transaction = session.beginTransaction();

//			
//			load() method
//			returns a proxy object and loads data only when it's actually required
//			studentid = session.load(Innovativestudents.class, invID);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return studentid;
	}

	@Override
	public void delete(int sid) {
		Innovativestudents studentid = null;
		Transaction transaction = null;

//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
		try (Session session = sessionFactory.openSession()) {
			// transaction begin
			transaction = session.beginTransaction();

			studentid = session.get(Innovativestudents.class, sid);
//			delete the student object
			session.delete(studentid);

//			load() method
//			returns a proxy object and loads data only when it's actually required
//			studentid = session.load(Innovativestudents.class, invID);

			// commit the transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Innovativestudents> findAll() {
		Transaction transaction = null;

		List<Innovativestudents> students = null;
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
		try (Session session = sessionFactory.openSession()) {
//			transaction begin
			transaction = session.beginTransaction();

//			get the list of student object we want to use hql cretiria
//			we are using hql language
			students = session.createQuery("from student").list();

//			commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}

}
