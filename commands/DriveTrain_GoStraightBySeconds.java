package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.Robot;
import org.usfirst.frc.team5484.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrain_GoStraightBySeconds extends Command implements PIDOutput{

	AHRS robotGyro = RobotMap.driveTrainGyro;
	PIDController turnController;
	double requestedSpeed;
	double requestedSeconds;
	double rotateToAngleRate;
	final double kP = 0.03;
	final double kI = 0.00;
	final double kD = 0.00;
	final double kF = 0.00;
	final double kToleranceDegrees = 2.0f;
	Timer timer;
	
    public DriveTrain_GoStraightBySeconds(double speed, double seconds) {
    	requires(Robot.driveTrain);
    	requestedSpeed = speed;
    	requestedSeconds = seconds;
    }

    protected void initialize() {
    	robotGyro.reset();
    	timer = new Timer();
    	turnController = new PIDController(kP, kI, kD, kF, robotGyro, this);
        turnController.setInputRange(-45.0f,  45.0f);
        turnController.setOutputRange(-0.9, 0.9);
        turnController.setAbsoluteTolerance(kToleranceDegrees);
        turnController.setContinuous(true);
        turnController.setSetpoint(0);
        turnController.enable();
    	timer.start();
    }

    protected void execute() {
    	Robot.driveTrain.driveStraight(requestedSpeed, rotateToAngleRate);
    }

    protected boolean isFinished() {
        return timer.get() > requestedSeconds;
    }

    protected void end() {
    	turnController.disable();
    	Robot.driveTrain.stopMotors();
    }

    protected void interrupted() {
    	end();
    }
    
    @Override
    public void pidWrite(double output) {
        rotateToAngleRate = output;
    }
}
