package presentation;

import java.awt.Point;

import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;
import ch.aplu.robotsim.UltrasonicSensor;

public class wall_following {
	public wall_following(){
		LegoRobot robot = new LegoRobot();
		Gear gear = new Gear();
		robot.addPart(gear);
		UltrasonicSensor us_front = new UltrasonicSensor(SensorPort.S1);
		robot.addPart(us_front);
		UltrasonicSensor us_right = new UltrasonicSensor(SensorPort.S4);
		robot.addPart(us_right);
		gear.setSpeed(100);
		gear.forward();
		while (true){
			int dist_f = us_front.getDistance();
			int dist_r = us_right.getDistance();
			if (dist_f <= 50){
				gear.backward(40);
				gear.left(50);
				//gear.forward(100);
				
			}else {
				if(dist_r <60 ){
					gear.left(20);
					gear.stop();
					gear.forward(100);
					gear.stop();
				}else if(dist_r >= 60 && dist_r <= 70){
					gear.forward();
				}else if(dist_r > 70){
					gear.right();
					gear.forward();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new wall_following();
	}
	static
	{
	 Point[] mesh_hbar =
	 {
	   new Point(200, 10), new Point(-200, 10),
	   new Point(-200, -10), new Point(200, -10)
	 };
	 Point[] mesh_vbar =
	 {
	   new Point(10, 200), new Point(-10, 200),
	   new Point(-10, -200), new Point(10, -200)
	 };
	 RobotContext.useTarget("sprites/bar0.gif", mesh_hbar, 250, 100);
	 RobotContext.useTarget("sprites/bar0.gif", mesh_hbar, 250, 400);
	 RobotContext.useTarget("sprites/bar1.gif", mesh_vbar, 100, 250);
	 RobotContext.useTarget("sprites/bar1.gif", mesh_vbar, 400, 250); 
	}

	


}
