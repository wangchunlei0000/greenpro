package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.CyPoj;

/**
 * A data access object (DAO) providing persistence and search support for CyPoj
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.wl.pojo.CyPoj
 * @author MyEclipse Persistence Tools
 */

public class CyPojDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CyPojDAO.class);
	// property constants
	public static final String MONEY = "money";
	public static final String BY1 = "by1";

	@SuppressWarnings("finally")
	public boolean save(CyPoj c) {
		log.debug("saving CyPoj instance");
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("CyPOj");
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

	public void delete(CyPoj persistentInstance) {
		log.debug("deleting CyPoj instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CyPoj findById(java.lang.Integer id) {
		log.debug("getting CyPoj instance with id: " + id);
		try {
			CyPoj instance = (CyPoj) getSession().get("org.wl.pojo.CyPoj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CyPoj instance) {
		log.debug("finding CyPoj instance by example");
		try {
			List results = getSession().createCriteria("org.wl.pojo.CyPoj")
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
		log.debug("finding CyPoj instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CyPoj as model where model."
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
	public boolean merge(CyPoj c) {
		log.debug("merging CyPoj instance");
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("cypoj");
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

	public void attachDirty(CyPoj instance) {
		log.debug("attaching dirty CyPoj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CyPoj instance) {
		log.debug("attaching clean CyPoj instance");
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
			String queryString = "from CyPoj where rongziPoj.pojid="+pojid+" and users.userid='"+userid+"'";
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
		log.debug("finding all CyPoj instances");
		try {
			String queryString = "from CyPoj where users.userid='"+userid+"'";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
//	public List findAll(Integer currentPage, Integer pageSize,String userid,String name,Integer id,Integer id2) {
//		log.debug("finding all CyPoj instances");
//		try {
//			StringBuffer sb = new StringBuffer();
//			sb.append("select count(*) from CyPoj where users.userid='"+userid+"'");
//			if(!"".equals(name)&name!=null) {sb.append(" and rongziPoj.name like '%"+name+"%'");}
//			if(id!=null&!"".equals(id)){sb.append(" and rongziPoj.rongziState.id="+id);}
//			if(id2!=null&!"".equals(id2)){sb.append(" and rongziPoj.rongziType.id="+id2);}
//			String queryString = sb.toString();
//			Query queryObject = getSession().createQuery(queryString).setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}

	public int getRowByTitle(String userid,String name, Integer id, Integer id2) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from CyPoj where users.userid='"+userid+"'");
			if(!"".equals(name)&name!=null) {sb.append(" and rongziPoj.name like '%"+name+"%'");}
			if(id!=null&!"".equals(id)){sb.append(" and rongziPoj.rongziState.id="+id);}
			if(id2!=null&!"".equals(id2)){sb.append(" and rongziPoj.rongziType.id="+id2);}
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
			String queryString = "from CyPoj where rongziPoj.pojid="+pojid;
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}