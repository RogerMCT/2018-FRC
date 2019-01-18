/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5484.robot;
import org.usfirst.frc.team5484.robot.commands.*;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;

public class OI 
{
	public static JoystickButton driverOneButton_EjectFast;
	public static JoystickButton driverOneButton_GrabLeft;
	public static JoystickButton driverOneButton_GrabRight;
	public static JoystickButton driverOneButton_EjectCube;
	public static JoystickButton driverOneButton_Climb;
	public static JoystickButton driverOneButton_Descend;
	
	public static JoystickButton driverTwoButton_Portal;
	public static JoystickButton driverTwoButton_HoldLift;
	public static JoystickButton driverTwoButton_StopLift;
	public static JoystickButton driverTwoButton_DropLift;
	public static JoystickButton driverTwoButton_LiftSwitch;
	public static JoystickButton driverTwoButton_LiftMidScale;
	public static JoystickButton driverTwoButton_LiftHighScale;
	public static JoystickButton driverTwoButton_LiftTopScale;
	public static JoystickButton driverTwoButton_IntakeGrab;
	public static JoystickButton driverTwoButton_IntakeEject;
	
	public static JoystickButton driverTwoButton_Turn90;
	
	public static JoystickButton liftSTOP;
	
    public static XboxController driverOne;
    public static Joystick driverTwo;

    public OI() {
    	driverOne = new XboxController(0);
    	driverTwo = new Joystick(1);
        
        // Driver One Functions
    	driverOneButton_EjectFast = new JoystickButton(driverOne, 6);
    	driverOneButton_EjectFast.whileHeld(new Intake_EjectCube(.7));
    	
    	driverOneButton_GrabLeft = new JoystickButton(driverOne, 2);
    	driverOneButton_GrabLeft.whileHeld(new Intake_GrabLeft(.7));
    	
    	driverOneButton_GrabRight = new JoystickButton(driverOne, 1);
    	driverOneButton_GrabRight.whileHeld(new Intake_GrabRight(.7));
        
    	driverOneButton_EjectCube = new JoystickButton(driverOne, 5);
    	driverOneButton_EjectCube.whileHeld(new Intake_EjectCube(.3));
    	
    	driverOneButton_Climb = new JoystickButton(driverOne, 3);
    	driverOneButton_Climb.whileHeld(new Hang_Climb());
    	
    	driverOneButton_Descend = new JoystickButton(driverOne, 4);
    	driverOneButton_Descend.whileHeld(new Hang_Descend());
        
        // Driver Two Functions
    	driverTwoButton_Portal = new JoystickButton(driverTwo, 1);
    	driverTwoButton_Portal.whenPressed(new Lift_MoveToPosition(Lift.Portal));
    	
    	driverTwoButton_StopLift = new JoystickButton(driverTwo, 2);
    	driverTwoButton_StopLift.whenPressed(new Lift_StopLift());
    	
    	driverTwoButton_HoldLift = new JoystickButton(driverTwo, 3);
    	driverTwoButton_HoldLift.whenPressed(new Lift_HoldLift());
    	
    	driverTwoButton_DropLift = new JoystickButton(driverTwo, 4);
    	driverTwoButton_DropLift.whenPressed(new Lift_DropLift());
        
    	driverTwoButton_LiftSwitch = new JoystickButton(driverTwo, 5);
    	driverTwoButton_LiftSwitch.whenPressed(new Lift_MoveToPosition(Lift.Switch));
        
    	driverTwoButton_LiftMidScale = new JoystickButton(driverTwo, 6);
    	driverTwoButton_LiftMidScale.whenPressed(new Lift_MoveToPosition(Lift.MidScale));
        
    	driverTwoButton_LiftHighScale = new JoystickButton(driverTwo, 7);
    	driverTwoButton_LiftHighScale.whenPressed(new Lift_MoveToPosition(Lift.HighScale));
        
    	driverTwoButton_LiftTopScale = new JoystickButton(driverTwo, 8);
    	driverTwoButton_LiftTopScale.whenPressed(new Lift_MoveToPosition(Lift.TopScale));
        
    	driverTwoButton_IntakeGrab = new JoystickButton(driverTwo, 9);
    	driverTwoButton_IntakeGrab.whileHeld(new Intake_GrabCube(.7));
        
    	driverTwoButton_IntakeEject = new JoystickButton(driverTwo, 10);
    	driverTwoButton_IntakeEject.whileHeld(new Intake_EjectCube(.7));
                
        SmartDashboard.putData("Take Cube In", new Intake_GrabCube(.7));
        SmartDashboard.putData("Eject Cube Out", new Intake_EjectCube(.7));
        SmartDashboard.putData("Intake Cube for 2 seconds", new Intake_GrabCubeForSeconds(2));
    }
    
    public double getDriverOneStickValue(int joyStickAxis){
    	return driverOne.getRawAxis(joyStickAxis);
    }
    public double getDriverTwoStickValue(int joyStickAxis){
    	return driverTwo.getRawAxis(joyStickAxis);
    }
    
}
