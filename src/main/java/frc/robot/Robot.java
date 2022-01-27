/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.libraries.*;

import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.subsystem.talonTest;

import frc.libraries.DriveTrain1038;
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
  // private final driveTrain1038 driveTrain = driveTrain1038.getInstance()
  Gyro1038 gyro = Gyro1038.getInstance();
  DriveTrain1038 driveTrain = DriveTrain1038.getInstance();
  boolean prevAButton = false;

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
    driveTrain.resetEncoders();
  }

  // Following code loop in teleOP repreatedly
  public void teleopPeriodic() {

    // if(operatorJoystick.getXButton()) {
    // talonTest.TalonLeft();
    // }

    // if(operatorJoystick.getYButton()) {
    // talonTest.TalonRight();
    // }
    talonTest.TalonRight();

    driveTrain.tankDrive(driverJoystick.getLeftJoystickVertical() * .8, driverJoystick.getRightJoystickVertical() * .8);

  }

  // Function contains code for operating systems that loops in teleOp
  public void operator() {
    if (operatorJoystick.getXButton()) {

      System.out.println(gyro.getAngle());
    }

    if (driverJoystick.getAButton()) {
      if (!prevAButton) {
        if (driveTrain.isHighGear) {
          driveTrain.lowGear();
        } else {
          driveTrain.highGear();
        }
      }
      prevAButton = true;
    } else {
      prevAButton = false;
    }
  }

  // // Function contains code for driving that loops in teleOp
  public void driver() {
    driveTrain.dualArcadeDrive(driverJoystick.getLeftJoystickVertical(), driverJoystick.getRightJoystickHorizontal());

    // System.out.println("Left Encoder: " + driveTrain.getCANSparkLeftEncoder());
    // System.out.println("Left Distance: " +
    // driveTrain.getLeftDriveEncoderDistance() + " inches");
    // System.out.println("Right Encoder: " + driveTrain.getCANSparkRightEncoder());
    // System.out.println("Right Distance: " +
    // driveTrain.getRightDriveEncoderDistance() + " inches");
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
