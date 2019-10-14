package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.NewsType;

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
public class NewsTypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NewsTypeDAO.class);
	// property constants
	public static final String STYLE = "style";
	public static final String ENABLE = "enable";

	public boolean save(NewsType o) {
		log.debug("saving NewsType instance");
			boolean b=false;
			getSession().beginTransaction();
		try {
			getSession().save(o);
			getSession().getTransaction().commit();
			b=true;
			log.debug("save successful");
		} catch (RuntimeException re) {
			getSession().getTransaction().rollback();
			log.error("save failed", re);
			throw re;
		} finally{
			return b;
		}
	}
	
	public boolean update(NewsType o) {
		log.debug("update NewsType instance");
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

	public boolean delete(NewsType persistentInstance) {
	
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

	public NewsType findById(java.lang.Integer id) {
		log.debug("getting NewsType instance with id: " + id);
		try {
			NewsType instance = (NewsType) getSession().get(
					"org.wl.pojo.NewsType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NewsType instance) {
		log.debug("finding NewsType instance by example");
		try {
			List results = getSession().createCriteria("org.wl.pojo.NewsType")
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
		log.debug("finding NewsType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from NewsType as model where model."
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
		log.debug("finding all NewsType instances");
		try {
			String queryString = "from NewsType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public boolean merge(NewsType detachedInstance) {
		log.debug("merging NewsType instance");
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

	public boolean attachDirty(NewsType instance) {
		log.debug("attaching dirty NewsType instance");
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

	public void attachClean(NewsType instance) {
		log.debug("attaching clean NewsType instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findAllke() {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("from NewsType where enable=true");
			
			String queryString = sb.toString();
			Query queryObject = getSession().createQuery(queryString);//.setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize);
			return queryObject.list();
		}catch(RuntimeException re){
			re.printStackTrace();
			return null;
		}finally{
			getSession().close();
		}

	}
}