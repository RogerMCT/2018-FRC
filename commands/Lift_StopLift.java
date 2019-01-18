package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Lift_StopLift extends Command {
	
	Timer time;

    public Lift_StopLift() {
        requires(Robot.liftSystem);
    }

    protected void initialize() {
    	Robot.liftSystem.disable();
    	Robot.liftSystem.stopLift();
    	time = new Timer();
    	time.start();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(time.get() > .1)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    protected void end() {
    	Robot.liftSystem.stopLift();
    }
    protected void interrupted() {
    	end();
    }
}
