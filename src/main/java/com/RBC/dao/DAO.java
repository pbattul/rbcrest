package com.RBC.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.RBC.model.RobotVO;

@Repository
public interface DAO {
	
	public void addRobot(RobotVO robot) throws Exception;
	public RobotVO getRobot(int id) throws Exception;
	public void deleteRobot(int id) throws Exception;
	public void updateRobot(RobotVO robot) throws Exception;
	public List<RobotVO> findAllRobots() throws Exception;
}
