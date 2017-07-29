package com.RBC.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RBC.model.RobotVO;

@Service
public interface ServiceBO {
	
	public void addRobot(RobotVO robot) throws Exception;
	public RobotVO getRobot(int id) throws Exception;
	public void deleteRobot(int id) throws Exception;
	public void updateRobot(RobotVO robot) throws Exception;
	public List<RobotVO> findAllRobots() throws Exception;

}
