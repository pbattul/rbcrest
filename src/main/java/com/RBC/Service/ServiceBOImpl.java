package com.RBC.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RBC.dao.DAO;
import com.RBC.model.RobotVO;

@Service
public class ServiceBOImpl implements ServiceBO {
	
	@Autowired
	DAO dao;
	
	List<RobotVO> robots = null;
	private int id; 

	@Override
	public void addRobot(RobotVO robot) throws Exception {
		System.out.println("In ServiceBOImpl.addRobot() method");
		robots = findAllRobots();
		id = 1;
		if(robots != null)
		{
			for(RobotVO robo : robots) {
				if(robo.getRobotId()>id)
					id=robo.getRobotId();
			}
			id+=1;
		}
		robot.setRobotId(id);
		dao.addRobot(robot);
	}

	@Override
	public RobotVO getRobot(int id) throws Exception {
		System.out.println("In ServiceBOImpl.getRobot() method");
		return dao.getRobot(id);
	}

	@Override
	public void deleteRobot(int id) throws Exception {
		System.out.println("In ServiceBOImpl.deleteRobot() method");
			dao.deleteRobot(id);
	}

	@Override
	public void updateRobot(RobotVO robot) throws Exception {
		dao.updateRobot(robot);
	}

	@Override
	public List<RobotVO> findAllRobots() throws Exception {
		return dao.findAllRobots();
	}

	

}
