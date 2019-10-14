package org.g.dao;

import java.util.List;

import org.g.pojo.TouziState;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * NewsType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wl.pojo.NewsType
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("finally")
public class TouziStateDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TouziStateDAO.class);
	// property constants
	public static final String STYLE = "style";
	public static final String ENABLE = "enable";

	public boolean save(TouziState o) {
		log.debug("saving TouziState instance");
		boolean b=false;
		getSession().beginTransaction();
		try {
			System.out.println("be save");
			getSession().save(o);
			System.out.println("hind save");
			getSession().getTransaction().commit();
			b=true;
			log.debug("save successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			System.out.println("fail");
			log.error("save failed", re);
			throw re;
		} finally{
			return b;
		}
	}
	
	public boolean update(TouziState o) {
		
		boolean b=false;
		getSession().beginTransaction();
		try {
			getSession().update(o);
			getSession().getTransaction().commit();
			b=true;
			log.debug("update successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("update failed", re);
			System.out.println(re);
			throw re;
		} finally{
			return b;
		}
	}

	public boolean delete(TouziState persistentInstance) {
	
		boolean b=false;
		getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			getSession().getTransaction().commit();
			b=true;
			log.debug("delete successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("delete failed", re);
			System.out.println(re);
			throw re;
		} finally{
			return b;
		}
	}

	public TouziState findById(java.lang.Integer id) {
		log.debug("getting TouziType instance with id: " + id);
		try {
			TouziState instance = (TouziState) getSession().get(
					"org.g.pojo.TouziState", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TouziState instance) {
		log.debug("finding TouziType instance by example");
		try {
			List results = getSession().createCriteria("org.g.pojo.TouziState")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TouziState instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TouziState as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStyle(Object style) {
		return findByProperty(STYLE, style);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findAll() {
		log.debug("finding all TouziState instances");
		try {
			String queryString = "from TouziState";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public boolean merge(TouziState detachedInstance) {
		log.debug("merging TouziState instance");
		getSession().beginTransaction();
	    boolean b=false;
		try {
			getSession().merge(detachedInstance);
			getSession().getTransaction().commit();
			log.debug("merge successful");
			b=true;
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("merge failed", re);
			System.out.println(re);
			throw re;
		}finally{
			getSession().close();
			return b;
		}
	}

	public boolean attachDirty(TouziState instance) {
		log.debug("attaching dirty TouziState instance");
		boolean b=false;
		getSession().beginTransaction();
		try {
			getSession().saveOrUpdate(instance);
			getSession().getTransaction().commit();
			log.debug("attach successful");
			b=true;
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("attach failed", re);
			throw re;
		} finally{
			return b;
		}
	}

	public void attachClean(TouziState instance) {
		log.debug("attaching clean TouziState instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}