package frc.subsystem;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.libraries.TalonFX1038;
import edu.wpi.first.wpilibj.controller.PIDController;

public class talonTest implements Subsystem {
    static TalonFX1038 motor1 = new TalonFX1038(2);

    public static void TalonRight() {
        motor1.set(.6);
    }

    public static void TalonLeft() {

        motor1.set(-.25);
    }
}
