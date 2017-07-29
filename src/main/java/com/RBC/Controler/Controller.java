package com.RBC.Controler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.RBC.Service.ServiceBO;
import com.RBC.model.CustomErr;
import com.RBC.model.RobotVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
@Api(value="RobotStore", description="Operations pertaining to products in Robots Store")
public class Controller {
	
	@Autowired
	RobotVO robot;
	@Autowired
	ServiceBO service;
	
	/*@RequestMapping(value="/home")
	public ResponseEntity<?> login() {
		robot.setName("testRObot");
		robot.setPrice(123);
		robot.setRobotId(1);
		System.out.println("Inside login method.......");
		return new ResponseEntity<RobotVO>(robot, HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value="/getRobo",method=RequestMethod.GET,consumes=MediaType.ALL_VALUE,produces=MediaType.ALL_VALUE)
	public RobotVO getRobot(HttpServletRequest request,HttpServletResponse response) {
		RobotVO robot = new RobotVO();
		robot.setName("Krishna");
		robot.setPrice(123);
		robot.setRobotId(1);
		response.addHeader("Access-Controll-Allow-Origin", "http://localhost:8086");
		response.addHeader("Access-Controll-Allow-Origin", "*");
		return robot;
	}*/

	@ApiOperation(value="AddRobot")
	@ApiResponses(value= {
			@ApiResponse(code=200, message = "Success"),
			@ApiResponse(code=201, message = "Created"),
			@ApiResponse(code=204, message = "No Content"),
			@ApiResponse(code=400, message = "Bad Request"),
			@ApiResponse(code=404, message = "Not Found"),
			@ApiResponse(code=500, message = "Failure")
	})
	@RequestMapping(value="/robot",method=RequestMethod.POST)
	public ResponseEntity<?> addRobot(@RequestBody RobotVO robot) throws Exception{
		service.addRobot(robot);
        return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/robot/{robotId}",method=RequestMethod.GET)
	public ResponseEntity<?> getRobot(@PathVariable("robotId") int robotId) throws Exception{
		 robot = service.getRobot(robotId);
	    if (robot == null) {
	            return new ResponseEntity(new CustomErr("User with id " +
	            			robotId + " not found"), HttpStatus.NOT_FOUND);
	    }
	        return new ResponseEntity<RobotVO>(robot, HttpStatus.OK);
	}
	
	@RequestMapping(value="/robot/{robotId}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteRobot(@PathVariable("robotId") int robotId) throws Exception{
		
		service.deleteRobot(robotId);
        return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/robot/{robotId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRobot(@PathVariable("robotId") int robotId, @RequestBody RobotVO updateRobo) throws Exception{
 
       /* robot = service.getRobot(robotId);
 
        if (robot == null) {
            return new ResponseEntity(new CustomErr("Unable to upate. User with id " + 
            			robotId + " not found."), HttpStatus.NOT_FOUND);
        }*/
        if(!StringUtils.isEmpty(updateRobo.getName()))
        	robot.setName(updateRobo.getName());
        if(!StringUtils.isEmpty(updateRobo.getPrice()))
        	robot.setPrice(updateRobo.getPrice());
        service.updateRobot(updateRobo);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/robots", method = RequestMethod.GET)
	    public ResponseEntity<List<RobotVO>> listAllUsers() throws Exception{
	        List<RobotVO> robots = service.findAllRobots();
	        if (robots.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<RobotVO>>(robots, HttpStatus.OK);
	    }
	

}
