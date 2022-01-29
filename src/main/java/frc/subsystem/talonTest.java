package frc.subsystem;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.libraries.TalonFX1038;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.controller.PIDController;

public class talonTest implements Subsystem {
    static TalonFX1038 motor1 = new TalonFX1038(2);
    private static double startSpeed = .1;
    private static talonTest motorTest;

    public static talonTest getInstance() {
        if (motorTest == null) {
            System.out.println("Creating a new DriveTrain");
            motorTest = new talonTest();
        }
        return motorTest;
    }

    public static void TalonRight() {
        motor1.set(.6);
    }

    public static void TalonLeft() {

        motor1.set(-.25);
    }

    public void talonRampUp() {
        motor1.setNeutralMode(NeutralMode.Coast);
        if (startSpeed <= .7) {
            startSpeed += .01;
            System.out.println("Shooter Speed:" + startSpeed);
            motor1.set(startSpeed);
        }
    }
}
