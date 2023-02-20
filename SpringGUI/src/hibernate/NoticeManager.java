package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class NoticeManager {
	private static NoticeManager instance;
	private SessionFactory factory;
	private String resource="hibernate/hibernate.cfg.xml";
	
	private NoticeManager() {
		Configuration config = new Configuration().configure(resource);
		StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
		sb.applySettings(config.getProperties());
		StandardServiceRegistry registry = sb.build();
		factory=config.buildSessionFactory(registry);
	}
	
	public SessionFactory getFactory() {
		return factory;
	}
	public void release(SessionFactory factory) {
		factory.close();
	}
	
	public static NoticeManager getInstance() {
		if(instance == null) {
			instance = new NoticeManager();
		}
		return instance;
	}
}
