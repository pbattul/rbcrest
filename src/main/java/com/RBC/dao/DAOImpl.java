package com.RBC.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.RBC.model.RobotVO;

@Repository
@Transactional
public class DAOImpl implements DAO {
	
	@Autowired
	RobotVO robot;
	
	@Autowired
	SessionFactory session;
	
	Session s;
	Transaction tx;
	
	@Override
	public void addRobot(RobotVO robot) throws Exception {
		try {
			s = session.openSession();
			tx = s.beginTransaction();
			s.save(robot);
			tx.commit();
			s.close();
		}
		catch (HibernateException e) {
	        tx.rollback();
	        throw new HibernateException(e.getMessage());
		}
	}

	@Override
	public RobotVO getRobot(int id) throws Exception {
		/*s = session.getCurrentSession();
		robot = (RobotVO)s.get(RobotVO.class, id);*/
		try {
		s = session.openSession();
		tx = s.beginTransaction();
		robot = (RobotVO)s.get(RobotVO.class, id);
		tx.commit();
		s.close();
		}
		catch (HibernateException e) {
			tx.rollback();
	        throw new HibernateException(e.getMessage());
        }
		return robot;
	}

	@Override
	public void deleteRobot(int id) throws Exception {
		try{
			s = session.openSession();
			tx = s.beginTransaction();
			robot = (RobotVO)s.get(RobotVO.class, id);
			s.delete(robot);
			tx.commit();
			s.close();
		}
		catch (HibernateException e) {
			tx.rollback();
	        throw new HibernateException(e.getMessage());
		}
	}

	@Override
	public void updateRobot(RobotVO robot) throws Exception {
		try{
			s = session.openSession();
			tx = s.beginTransaction();
			s.update(robot);
			tx.commit();
		}
		catch (HibernateException e) {
			tx.rollback();
	        throw new HibernateException(e.getMessage());
	    }
	}

	@Override
	public List<RobotVO> findAllRobots() throws Exception {
		List<RobotVO> robots = null;
		try{
			s = session.openSession();
			tx = s.beginTransaction();
			robots = s.createQuery("FROM ROBOT").list();
			tx.commit();
		}
		catch (HibernateException e) {
			tx.rollback();
	        throw new HibernateException(e.getMessage());
	    }
		return robots;
	}

}
