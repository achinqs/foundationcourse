package presentation;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.LightSensor;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;
import ch.aplu.robotsim.Tools;

public class line_follower {
	private Gear gear = new Gear();
	public line_follower(){
		LegoRobot robot = new LegoRobot();
		robot.addPart(gear);
		LightSensor s1 = new LightSensor(SensorPort.S1); //S1 = rigth S2=left
		robot.addPart(s1);
		LightSensor s2 = new LightSensor(SensorPort.S2);
		robot.addPart(s2);
		gear.forward(30);
		while(true){
			int ss1 = s1.getValue();
			int ss2 = s2.getValue();
			
			if (ss1>0 && ss2==0){
				gear.forward();
			}else if(ss1==0 && ss2==0){
				gear.right();
			}else if(ss1>0 && ss2>0){
				gear.left();
			}
			
				
				System.out.println("S1 = "+s1.getValue());
				System.out.println("S2 = "+s2.getValue());
			
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new line_follower();
	}
	
	static{
	    RobotContext.setStartPosition(100, 200);
	    RobotContext.setStartDirection(-90);
	    RobotContext.useBackground("sprites/bg.gif");
	  
	} 
}
