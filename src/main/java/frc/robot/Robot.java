/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.libraries.*;
import frc.libraries.DriveTrain1038;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

  public class Robot extends TimedRobot {
    Joystick1038 driverJoystick = new Joystick1038(0);
    Joystick1038 operatorJoystick = new Joystick1038(1);

    //Test solenoid
    private final int PTO_ON = 2;
    private final int PTO_OFF = 3;
    public DoubleSolenoid testSolenoid = new DoubleSolenoid(PTO_ON, PTO_OFF);

    //Compressor
    public Compressor c = new Compressor();

    //Drive Train
    private final DriveTrain1038 driveTrain = DriveTrain1038.getInstance();
    private double drivePower = 0;
    public double multiplyer = .8;
    /*
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
  
    @Override
    public void robotInit() {
    }
  
    @Override
    public void robotPeriodic() {
    }
  
    public void teleopInit() {
    }
  
    public void teleopPeriodic() {
      if (driverJoystick.getAButton()){
        testSolenoid.set(DoubleSolenoid.Value.kForward);
      }
      if (driverJoystick.getBButton()){
        testSolenoid.set(DoubleSolenoid.Value.kReverse);
      }
      driver();
    }

    public void driver() {
      switch (driveTrain.currentDriveMode) {
        case tankDrive:
          driveTrain.tankDrive(driverJoystick.getLeftJoystickVertical() * multiplyer,
              driverJoystick.getRightJoystickVertical() * multiplyer);
          break;
        case dualArcadeDrive:
          if (driverJoystick.deadband(driverJoystick.getLeftJoystickVertical()) > 0) {
            drivePower = (driverJoystick.getLeftJoystickVertical() - .1) * (1 / .9);
          } else if (driverJoystick.deadband(driverJoystick.getLeftJoystickVertical()) < 0) {
            drivePower = (driverJoystick.getLeftJoystickVertical() + .1) * (1 / .9);
          } else {
            drivePower = 0;
          }
          driveTrain.dualArcadeDrive(drivePower * multiplyer, driverJoystick.getRightJoystickHorizontal() * multiplyer);
          break;
        case singleArcadeDrive:
          driveTrain.singleAracadeDrive(driverJoystick.getLeftJoystickVertical() * multiplyer,
              driverJoystick.getLeftJoystickHorizontal() * multiplyer);
          break;
      }
  
      if (driverJoystick.getRightButton() && driverJoystick.getRightTrigger() > .5) {
        multiplyer = 1;
        driveTrain.highGear();
      } else if (driverJoystick.getRightButton()) {
        multiplyer = 1;
        driveTrain.lowGear();
      } else if (driverJoystick.getRightTrigger() > .5) {
        multiplyer = .8;
        driveTrain.highGear();
      } else {
        multiplyer = .8;
        driveTrain.lowGear();
      }
    }

  
    public void autonomousInit() {
    }
  
    public void autonomousPeriodic() {
    }
  
    public void disabledInit() {
    }
  
    public void disabledPeriodic() {
    }
  
    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testInit() {
    }
  
    @Override
    public void testPeriodic() {
    }
  
  
 }

