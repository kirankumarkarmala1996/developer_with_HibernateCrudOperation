package com.innovatitive.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.innovatitive.dao.StudentDaoImpl;
import com.innovatitive.model.Innovativestudents;

public class ClientApp {

	public static void main(String[] args) {
//		Configuration configuration = new Configuration().configure("src/main/resources/Hibernate.cfg.xml");
//		SessionFactory sessionFactory=configuration.buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Transaction transaction=session.beginTransaction();
		StudentDaoImpl daoimpl = new StudentDaoImpl();
		Innovativestudents student = new Innovativestudents("karmala", "kiran", "kumar", 124536789, "kiran@abc.com",
				"hyd", 25000.00);
		daoimpl.save(student);

// update student
		student.setFirs_Name("kamsala");
		daoimpl.update(student);

//find by id
		Innovativestudents student1 = daoimpl.findById(student.getSid());
		System.out.println(student1);
		
//		List<Innovativestudents>students=daoimpl.findAll();
//		for(Innovativestudents stu:students) {
//			System.out.println(stu.getSid());
//		}
//		

//delete the student
		daoimpl.delete(student.getSid());

//		students.forEach(allStudents->System.out.println(allStudents.getSid()));

//		Innovativestudents student2 = new Innovativestudents("kamsala","kiran","kumar",124536789,"kamsala@abc.com","pune",25000.00);
//		daoimpl.save(student2);
	}

}
