package org.wl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wl.pojo.RongziPoj;

/**
 * A data access object (DAO) providing persistence and search support for
 * RongziPoj entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.wl.pojo.RongziPoj
 * @author MyEclipse Persistence Tools
 */

public class RongziPojDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RongziPojDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String INTRODUCE = "introduce";
	public static final String ICON = "icon";
	public static final String MONEY = "money";
	public static final String NOWMONEY = "nowmoney";
	public static final String AREA = "area";
	public static final String PERIOD = "period";
	public static final String BY1 = "by1";
	public static final String BY2 = "by2";
	public static final String BY3 = "by3";

	
	
	
	//用户筛选  -项目-分页
	public int getRowByTitle(String userid,String name, Integer id, Integer id2) {
		try{
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from RongziPoj where users.userid='"+userid+"'");
			System.out.println(sb.toString());
			if(!"".equals(name)&name!=null) sb.append(" and name like '%"+name+"%'");System.out.println(sb.toString());
			if(!"".equals(id)&id!=null) sb.append(" and rongziState.id="+id);System.out.println(sb.toString());
			if(!"".equals(id2)&id2!=null) sb.append(" and rongziType.id="+id2);System.out.println(sb.toString());
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
	
	public List findAllByTitle(Integer currentPage, Integer  pageSize,String userid,String name, Integer id, Integer id2){
    	
    	try{
			StringBuffer sb = new StringBuffer();
			sb.append("from RongziPoj where users.userid='"+userid+"'");
			if(!"".equals(name)&name!=null) sb.append(" and name like '%"+name+"%'");
			if(!"".equals(id)&id!=null) sb.append(" and rongziState.id="+id);
			if(!"".equals(id2)&id2!=null) sb.append(" and rongziType.id="+id2);
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
 
	@SuppressWarnings("finally")
	public boolean save(RongziPoj p) {
			boolean b=false;
			getSession().beginTransaction();
		try {
			System.out.println("fhudifhadu");
			getSession().save(p);
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
	public boolean delete(RongziPoj p) {
			boolean b=false;
			getSession().beginTransaction();
		try {
			getSession().delete(p);
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

	public RongziPoj findById(java.lang.Integer id) {
		log.debug("getting RongziPoj instance with id: " + id);
		try {
			RongziPoj instance = (RongziPoj) getSession().get(
					"org.wl.pojo.RongziPoj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RongziPoj instance) {
		log.debug("finding RongziPoj instance by example");
		try {
			List results = getSession().createCriteria("org.wl.pojo.RongziPoj")
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
		log.debug("finding RongziPoj instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RongziPoj as model where model."
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

	public List findByIntroduce(Object introduce) {
		return findByProperty(INTRODUCE, introduce);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByMoney(Object money) {
		return findByProperty(MONEY, money);
	}

	public List findByNowmoney(Object nowmoney) {
		return findByProperty(NOWMONEY, nowmoney);
	}

	public List findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List findByBy1(Object by1) {
		return findByProperty(BY1, by1);
	}

	public List findByBy2(Object by2) {
		return findByProperty(BY2, by2);
	}

	public List findByBy3(Object by3) {
		return findByProperty(BY3, by3);
	}
	//管理员查看所有项目
	public List findAll() {
		log.debug("finding all RongziPoj instances");
		try {
			String queryString = "from RongziPoj";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAlljb() {
		log.debug("finding all RongziPoj instances");
		try {
			String queryString = "from RongziPoj where rongziState.id=6";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllByUser(String userid) {
		log.debug("finding all RongziPoj instances");
		try {
			String queryString = "from RongziPoj where users.userid='"+userid+"'";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	


 
	@SuppressWarnings("finally")
	public boolean merge(RongziPoj p) {
		
		boolean b=false;
		getSession().beginTransaction();
	try {
		System.out.println("fhudifhadu");
		getSession().merge(p);
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

	public void attachDirty(RongziPoj instance) {
		log.debug("attaching dirty RongziPoj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RongziPoj instance) {
		log.debug("attaching clean RongziPoj instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
// 游客 查看的项目 融资中、融资结束
	public List findAllPoj() {
		log.debug("finding all RongziPoj instances");
		try {
			System.out.println("RongziPojDAO.findAllPoj");
			String queryString = "from RongziPoj where rongziState.id !=5 and rongziState.id !=8";
			System.out.println("DAO.begin");
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List daishen() {
		try {
			System.out.println("RongziPojDAO.daishen");
			String queryString = "from RongziPoj where rongziState.id=1";
			System.out.println("DAO.begin");
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public int getyRowByTitle(String name, Integer id, Integer id2) {
		try{
			StringBuffer sb = new StringBuffer();
			System.out.println("DAO  row"+name);
			sb.append("select count(*) from RongziPoj where rongziState.id in (2,4)");
			if(!"".equals(name)&name!=null) {sb.append(" and name like '%"+name+"%'");}
			if(id!=null&!"".equals(id)){sb.append(" and rongziState.id="+id);}
			if(id2!=null&!"".equals(id2)){sb.append(" and rongziType.id="+id2);}
			String queryString = sb.toString();
			System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			return Integer.parseInt(queryObject.uniqueResult().toString());
		}catch(RuntimeException re){
			re.printStackTrace();
			return 0;
		}finally{
			getSession().close();
		}
	}
	
	public List yfindAllByTitle(Integer currentPage, Integer  pageSize,String name, Integer id, Integer id2){
    	
    	try{
			StringBuffer sb = new StringBuffer();
			sb.append("from RongziPoj where rongziState.id in (2,4)");
			if(!"".equals(name)&name!=null) {sb.append(" and name like '%"+name+"%'");}
			if(id!=null&!"".equals(id)){sb.append(" and rongziState.id="+id);}
			if(id2!=null&!"".equals(id2)){sb.append(" and rongziType.id="+id2);}
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

	public List jubao() {
		try {
			System.out.println("RongziPojDAO.jubao");
			String queryString = "from RongziPoj where rongziState.id=8";
			System.out.println("DAO.begin");
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List adminfindall(String name) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("from RongziPoj");
			if(name!=null&!"".equals(name)){
				sb.append(" where name like '%"+name+"%'");
			}
			
			String queryString = sb.toString();
			System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllstate(){
		try {
		
			String queryString = "from RongziPoj where rongziState.id=2";
			System.out.println("DAO.begin");
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}

	}


	public int getadRowByTitle(String name, Integer id, Integer id2) {
		try{
			StringBuffer sb = new StringBuffer();
			System.out.println("DAO  row"+name);
			sb.append("select count(*) from RongziPoj where rongziState.id!=9");
			if(!"".equals(name)&name!=null) {sb.append(" and name like '%"+name+"%'");}
			if(id!=null&!"".equals(id)){sb.append(" and rongziState.id="+id);}
			System.out.println("daoooooooooooooooooo id"+id);
			if(id2!=null&!"".equals(id2)){sb.append(" and rongziType.id="+id2);}
			String queryString = sb.toString();
			System.out.println(queryString);
			Query queryObject = getSession().createQuery(queryString);
			return Integer.parseInt(queryObject.uniqueResult().toString());
		}catch(RuntimeException re){
			re.printStackTrace();
			return 0;
		}finally{
			getSession().close();
		}
	}
	
	public List adfindAllByTitle(Integer currentPage, Integer  pageSize,String name, Integer id, Integer id2){
    	
    	try{
			StringBuffer sb = new StringBuffer();
			sb.append("from RongziPoj where  rongziState.id!=9");
			if(!"".equals(name)&name!=null) {sb.append(" and name like '%"+name+"%'");}
			if(id!=null&!"".equals(id)){sb.append(" and rongziState.id="+id);}
			if(id2!=null&!"".equals(id2)){sb.append(" and rongziType.id="+id2);}
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


	

	
}