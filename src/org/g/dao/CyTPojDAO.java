package org.g.dao;

import java.util.List;

import org.g.pojo.CyTPoj;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for CyPoj
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.g.pojo.CyTPoj
 * @author MyEclipse Persistence Tools
 */

public class CyTPojDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CyTPojDAO.class);
	// property constants
	public static final String MONEY = "money";
	public static final String BY1 = "by1";

	@SuppressWarnings("finally")
	public boolean save(CyTPoj c) {
		log.debug("saving CyTPoj instance");
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("CyTPOj");
		getSession().save(c);
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

	public void delete(CyTPoj persistentInstance) {
		log.debug("deleting CyTPoj instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CyTPoj findById(java.lang.Integer id) {
		log.debug("getting CyTPoj instance with id: " + id);
		try {
			CyTPoj instance = (CyTPoj) getSession().get("org.g.pojo.CyTPoj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CyTPoj instance) {
		log.debug("finding CyTPoj instance by example");
		try {
			List results = getSession().createCriteria("org.g.pojo.CyTPoj")
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
		log.debug("finding CyTPoj instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CyTPoj as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findByBy1(Object by1) {
		return findByProperty(BY1, by1);
	}

	

	@SuppressWarnings("finally")
	public boolean merge(CyTPoj c) {
		log.debug("merging CyTPoj instance");
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("cytpoj");
		getSession().merge(c);
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

	public void attachDirty(CyTPoj instance) {
		log.debug("attaching dirty CyTPoj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CyTPoj instance) {
		log.debug("attaching clean CyTPoj instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findBypu(int pojid,String userid) {
		try {
			String queryString = "from CyTPoj where touziPoj.pojid="+pojid+" and users.userid='"+userid+"'";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
//	public List findAllByUser(String userid) {
//		log.debug("finding all RongziPoj instances");
//		try {
//			String queryString = "from RongziPoj where users.userid='"+userid+"'";
//			Query queryObject = getSession().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}
	public List findAll(String userid) {
		log.debug("finding all CyTPoj instances");
		try {
			String queryString = "from CyTPoj where users.userid='"+userid+"'";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List statefindAll() {
		log.debug("finding all CyTPoj instances");
		try {
			String queryString = "from CyTPoj";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public int getRowByTitle(String userid,String name, Integer id, Integer id2) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from CyTPoj where users.userid='"+userid+"'");
			if(!"".equals(name)&name!=null) {sb.append(" and touziPoj.name like '%"+name+"%'");}
			if(id!=null&!"".equals(id)){sb.append(" and touziPoj.touziState.id="+id);}
			if(id2!=null&!"".equals(id2)){sb.append(" and touziPoj.touziType.id="+id2);}
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

	public List findByPojid(Integer pojid) {
		try {
			System.out.println("dao pojid"+pojid);
			String queryString = "from CyTPoj where touziPoj.pojid="+pojid;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}