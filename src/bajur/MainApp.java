package bajur;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bajur.entity.Instructor;
import bajur.entity.InstructorDetail;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Instructor tempInstructor = new Instructor("Andrzej","Strzelba","andrzej.strzelbix@bajur.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("abc.pl","Dziennikarstwo");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}

	}

}
