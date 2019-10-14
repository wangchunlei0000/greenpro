package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.UsersEmail;

/**
 * A data access object (DAO) providing persistence and search support for
 * UsersEmail entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wl.pojo.UsersEmail
 * @author MyEclipse Persistence Tools
 */

public class UsersEmailDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UsersEmailDAO.class);
	// property constants
	public static final String EMAIL = "email";
	public static final String TEXT = "text";
	public static final String N = "n";
	public static final String BY1 = "by1";

	@SuppressWarnings("finally")
	public boolean save(UsersEmail e) {
		log.debug("saving UsersEmail instance");
		boolean b = false;
		getSession().beginTransaction();
		try {
			getSession().save(e);
			getSession().getTransaction().commit();
			b=true;
			log.debug("save successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("save failed", re);
			throw re;
		}finally{
			getSession().close();
			return b;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(UsersEmail e) {
		log.debug("deleting UsersEmail instance");
		
			boolean b = false;
			getSession().beginTransaction();
			try {
				getSession().delete(e);
				getSession().getTransaction().commit();
				b=true;
				log.debug("save successful");
			} catch (RuntimeException re) {
				getSession().getTransaction().rollback();
				log.error("save failed", re);
				throw re;
			}finally{
				getSession().close();
				return b;
			}
	}

	public UsersEmail findById(java.lang.Integer id) {
		log.debug("getting UsersEmail instance with id: " + id);
		try {
			UsersEmail instance = (UsersEmail) getSession().get(
					"org.wl.pojo.UsersEmail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UsersEmail instance) {
		log.debug("finding UsersEmail instance by example");
		try {
			List results = getSession()
					.createCriteria("org.wl.pojo.UsersEmail").add(
							Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UsersEmail instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UsersEmail as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEmail(String email) {
		try {
			System.out.println("email dao start");
			String queryString = "from UsersEmail where email='"+email+"' order by n,by1 desc";
			System.out.println("essay   --------"+queryString);
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			re.printStackTrace();
			throw re;
		}finally{
			getSession().close();
		}
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByN(Object n) {
		return findByProperty(N, n);
	}

	public List findByBy1(Object by1) {
		return findByProperty(BY1, by1);
	}

	public List findAll() {
		log.debug("finding all UsersEmail instances");
		try {
			String queryString = "from UsersEmail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("finally")
	public boolean merge(UsersEmail e) {
		log.debug("merging UsersEmail instance");
		boolean b = false;
		getSession().beginTransaction();
		try {
			getSession().merge(e);
			getSession().getTransaction().commit();
			b=true;
			log.debug("save successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("save failed", re);
			throw re;
		}finally{
			getSession().close();
			return b;
		}
	}

	public void attachDirty(UsersEmail instance) {
		log.debug("attaching dirty UsersEmail instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UsersEmail instance) {
		log.debug("attaching clean UsersEmail instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}