package frc.subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.libraries.TalonSRX1038;

public class talonTest implements Subsystem {
    // Motor port numbers
    private final int talonMotorPort = 55;
    
    // Motors and encoders and sensors
    private TalonSRX1038 talonMotor = new TalonSRX1038(talonMotorPort);
    
    public void mover(double joystick) {
        if (joystick > 0) {
            talonMotor.set(.5);
        }
        else if (joystick < 0) {
            talonMotor.set(-.5);
        }
    }
}