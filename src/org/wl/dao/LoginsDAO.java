package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.Logins;

/**
 * A data access object (DAO) providing persistence and search support for
 * Logins entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wl.pojo.Logins
 * @author MyEclipse Persistence Tools
 */

public class LoginsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(LoginsDAO.class);
	// property constants
	public static final String PWD = "pwd";
	public static final String ROLE = "role";
	public static final String ENABLE = "enable";
	public static final String BEIYONG1 = "beiyong1";

	@SuppressWarnings("finally")
	public int updateEnableBatch(String flag,String ids){
		int b=0;
		try{
			getSession().getTransaction().begin();
			String hql="update Logins set enable = '"+flag+"' where userid in("+ids+")";
			b=getSession().createQuery(hql).executeUpdate();
			getSession().getTransaction().commit();
		}catch (RuntimeException re) {
			b=0;
			getSession().getTransaction().rollback();
			log.error("save failed", re);
			throw re;
		}finally{
			getSession().close();
			return b;
		}
	}
	@SuppressWarnings("finally")
	public boolean save(Logins transientInstance) {
		
		log.debug("saving Logins instance");
		boolean b = false;
		try {
			getSession().beginTransaction();
			getSession().save(transientInstance);
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
	public boolean delete(Logins o) {
		log.debug("deleting Logins instance");
		boolean b = false;
		try {
			getSession().beginTransaction();
			getSession().delete(o);
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

	public Logins findById(java.lang.String id) {
		log.debug("getting Logins instance with id: " + id);
		try {
			Logins instance = (Logins) getSession().get("org.wl.pojo.Logins",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public boolean check(java.lang.String id,java.lang.String pwd){
		boolean b=false;
		try{
			
		}catch(Exception e){
			throw e;
			
		}
		finally{return b;}
	}
	public List findByExample(Logins instance) {
		log.debug("finding Logins instance by example");
		try {
			List results = getSession().createCriteria("org.wl.pojo.Logins")
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
		log.debug("finding Logins instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Logins as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findByEnable(Object enable) {
		return findByProperty(ENABLE, enable);
	}

	public List findByBeiyong1(Object beiyong1) {
		return findByProperty(BEIYONG1, beiyong1);
	}

	public List findAll() {
		log.debug("finding all Logins instances");
		try {
			String queryString = "from Logins";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("finally")
	public boolean merge(Logins o) {
		log.debug("merging Logins instance");
		boolean b = false;
		try {
			getSession().beginTransaction();
			getSession().merge(o);
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

	public void attachDirty(Logins instance) {
		log.debug("attaching dirty Logins instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Logins instance) {
		log.debug("attaching clean Logins instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}