package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.NewsPoj;

/**
 * A data access object (DAO) providing persistence and search support for
 * NewsPoj entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wl.pojo.NewsPoj
 * @author MyEclipse Persistence Tools
 */

public class NewsPojDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(NewsPojDAO.class);
	// property constants
	public static final String TEXT = "text";
	public static final String HEAD = "head";
	public static final String ICON = "icon";
	public static final String COUNT = "count";
	public static final String STATE = "state";
	public static final String BY2 = "by2";

	@SuppressWarnings("finally")
	public boolean save(NewsPoj n) {
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("fhudifhadu");
		getSession().save(n);
		System.out.println("behinf success");
		getSession().getTransaction().commit();
		System.out.println("commit end");
		b=true;	
	} catch (RuntimeException re) {
		System.out.println("roll"+re);
		getSession().getTransaction().rollback();
		log.error("save failed", re);
		throw re;
	} finally{
		getSession().close();
		return b;
	}
	}

	@SuppressWarnings("finally")
	public boolean delete(NewsPoj persistentInstance) {
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

	public NewsPoj findById(java.lang.Integer id) {
		log.debug("getting NewsPoj instance with id: " + id);
		try {
			NewsPoj instance = (NewsPoj) getSession().get("org.wl.pojo.NewsPoj",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NewsPoj instance) {
		log.debug("finding NewsPoj instance by example");
		try {
			List results = getSession().createCriteria("org.wl.pojo.NewsPoj")
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
		log.debug("finding NewsPoj instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from NewsPoj as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByText(Object text) {
		return findByProperty(TEXT, text);
	}

	public List findByHead(Object head) {
		return findByProperty(HEAD, head);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByBy2(Object by2) {
		return findByProperty(BY2, by2);
	}

	public List findAll() {
		log.debug("finding all NewsPoj instances");
		try {
			String queryString = "from NewsPoj";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("finally")
	public boolean merge(NewsPoj n) {
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("fhudifhadu");
		getSession().merge(n);
		System.out.println("behinf success");
		getSession().getTransaction().commit();
		System.out.println("commit end");
		b=true;	
	} catch (RuntimeException re) {
		System.out.println("roll"+re);
		getSession().getTransaction().rollback();
		log.error("save failed", re);
		throw re;
	} finally{
		getSession().close();
		return b;
	}
	}

	public void attachDirty(NewsPoj instance) {
		log.debug("attaching dirty NewsPoj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewsPoj instance) {
		log.debug("attaching clean NewsPoj instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public int getRowByTitle(String userid, String head, Integer type) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from NewsPoj where users.userid='"+userid+"'");
			System.out.println(sb.toString());
			if(!"".equals(head)&head!=null) sb.append(" and head like '%"+head+"%'");
			System.out.println(sb.toString());
			if(!"".equals(type)&type!=null) sb.append(" and newsType.id="+type);
			System.out.println(sb.toString());
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

	public List findAllByTitle(int currentPage, int pageSize,
			String userid, String head, Integer type) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("from NewsPoj where users.userid='"+userid+"'");
			if(!"".equals(head)&head!=null) sb.append(" and head like '%"+head+"%'");
			if(!"".equals(type)&type!=null) sb.append(" and newsType.id="+type);
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
	
	public int getjRowByTitle(String userid) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from NewsPoj where users.userid='"+userid+"' and state='1'");
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

	public List jfindAllByTitle(int currentPage, int pageSize,
			String userid) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("from NewsPoj where users.userid='"+userid+"' and state='1'");
			
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

	public List yfindAllBy(Integer type, String head) {
		// TODO Auto-generated method stub
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("from NewsPoj where state='0'");
			if(!"".equals(head)&head!=null) sb.append(" and head like '%"+head+"%'");
			if(!"".equals(type)&type!=null) sb.append(" and newsType.id="+type);
			
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