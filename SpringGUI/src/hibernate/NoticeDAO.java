package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Notice;

public class NoticeDAO {
	private NoticeManager noticeManager;
	
	public NoticeDAO() {
		noticeManager = NoticeManager.getInstance();
		insert();
	}
	public void selectAll() {
		SessionFactory facotry=noticeManager.getFactory();
		
	}
	public void insert() {
		SessionFactory factory = noticeManager.getFactory();
		Session session=factory.openSession();
		Notice notice  = new Notice();
		notice.setTitle("hibernate test");
		Transaction tx=session.beginTransaction();
		session.save(notice);
		tx.commit();
		noticeManager.release(factory);
	}
	
	public static void main(String[] args) {
		new NoticeDAO();
	}
}
