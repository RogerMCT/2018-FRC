package org.usfirst.frc.team5484.robot.subsystems;

import org.usfirst.frc.team5484.robot.RobotMap;
import org.usfirst.frc.team5484.robot.commands.Lift_TeleopMode;
import org.usfirst.frc.team5484.robot.commands.Pneumatics_StartCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static Compressor compressor = RobotMap.compressor;
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Pneumatics_StartCompressor());
    }
    
    public void startCompressor() {
    	compressor.setClosedLoopControl(true);
    }
    
    public void stopCompressor() {
    	compressor.setClosedLoopControl(false);
    }
}

