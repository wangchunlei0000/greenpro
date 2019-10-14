package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.Users;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.wl.pojo.Users
 * @author MyEclipse Persistence Tools
 */

public class UsersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String USERNAME = "username";
	public static final String PHONE = "phone";
	public static final String EMAIL = "email";
	public static final String FAX = "fax";
	public static final String HEAD = "head";
	public static final String BEIYONG1 = "beiyong1";

	
	public List findAllByTitle(int currentPage,int pageSize,String role,String title){
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select l.enable,l.role,u from Logins l,Users u where l.userid=u.userid and l.role='0'");
			if(!"".equals(title)&title!=null) sb.append(" and l.userid like '%"+title+"%'");
			if(role.equals("2")) sb.append(" or l.role='1'");
			String queryString = sb.toString();
			Query queryObject = getSession().createQuery(queryString).setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize);
			return queryObject.list();
		}catch(RuntimeException re){
			re.printStackTrace();
			return null;
		}finally{
			getSession().close();
		}
	}
	public int getRowsByTitle(String role,String title){
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from Logins l,Users u where l.userid=u.userid and l.role='0'");
			if(!title.equals("")&title!=null) sb.append(" and l.userid like '%"+title+"%'");
			if(role.equals("2")) sb.append(" or l.role='1'");
			String queryString = sb.toString();
			Query queryObject = getSession().createQuery(queryString);
			return Integer.parseInt(queryObject.uniqueResult().toString());
		}catch(RuntimeException re){
			re.printStackTrace();
			return 0;
		}finally{
			getSession().close();
		}
	}
	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "select l.enable,l.role,u from Logins l,Users u where l.userid=u.userid and l.role='0'";
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
	
	@SuppressWarnings("finally")
	public boolean save(Users transientInstance) {
		log.debug("saving Users instance");
		boolean b = false;
		getSession().beginTransaction();
		try {
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
	public boolean merge(Users detachedInstance) {
		log.debug("merging users instance");
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

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.String id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getSession().get("org.wl.pojo.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List results = getSession().createCriteria("org.wl.pojo.Users")
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
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	public List findByHead(Object head) {
		return findByProperty(HEAD, head);
	}

	public List findByBeiyong1(Object beiyong1) {
		return findByProperty(BEIYONG1, beiyong1);
	}


	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}