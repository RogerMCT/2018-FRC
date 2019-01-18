package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Intake_GrabLeft extends Command {

	private double speedLevel;
	
    public Intake_GrabLeft(double powerLevel) {
    	requires(Robot.intakeSystem);
    	speedLevel = powerLevel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intakeSystem.grabLeft(speedLevel);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeSystem.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
