package org.usfirst.frc.team5484.robot.commands;

import org.usfirst.frc.team5484.robot.MatchData;
import org.usfirst.frc.team5484.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_Scale_Left extends CommandGroup {

	private MatchData.OwnedSide scaleSide = null;
	
    public Autonomous_Scale_Left() {
    	scaleSide = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
    	if (scaleSide == MatchData.OwnedSide.LEFT) {
        	addParallel(new Lift_MoveToPosition(Lift.HighScale), 8);
    		addSequential(new DriveTrain_DriveStraightForInches(.8, 257));
    		addSequential(new Report_Encoder());
    		addSequential(new DriveTrain_TurnToAngle(45));
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 10));
	        addSequential(new Intake_EjectForSeconds(1));
	        addSequential(new DriveTrain_DriveStraightForInches(-.6, 10));
	        addParallel(new Lift_MoveToPosition(Lift.Floor), 12);
	        addSequential(new DriveTrain_TurnToAngle(85));
	        addParallel(new Intake_GrabCubeForSeconds(4.5), 4);
    	    addSequential(new DriveTrain_DriveStraightForInches(.6, 71)); 
    	    addSequential(new Report_Encoder());
        } 
    	else {
        	addParallel(new Lift_MoveToPosition(Lift.Switch), 4);
    		addSequential(new DriveTrain_DriveStraightForInches(.6, 140));
        }
    }
}
