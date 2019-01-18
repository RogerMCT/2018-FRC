package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class Autonomous_CrossLine extends CommandGroup {

    public Autonomous_CrossLine() {
    	//DRIVE STRAIGHT WITH ENCODERS
    	//addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
		//addSequential(new DriveTrain_DriveStraightForInches(.7, 140));
    	
    	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    	addSequential(new DriveTrain_GoStraightBySeconds(0.6, 5));
    }
}