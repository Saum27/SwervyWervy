package frc.subsystem;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.libraries.TalonSRX1038;
import edu.wpi.first.wpilibj.controller.PIDController;
public class talonTest implements Subsystem {
    static TalonSRX1038 motor1 = new TalonSRX1038(65);
    

    public static void TalonRight() {
        motor1.set(.25);
    }

    public static void TalonLeft() {
        
        motor1.set(-.25);
    }
}
