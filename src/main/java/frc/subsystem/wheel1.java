package frc.subsystem;

import edu.wpi.first.wpilibj2.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import frc.libraries.CANSpark1038;

public class wheel1 implements Subsystem {

    private final static int RIGHT_FRONT_PORT = 53;
    private final static int RIGHT_BACK_PORT = 54;

    public static CANSpark1038 CANSparkRightFront = new CANSpark1038(RIGHT_FRONT_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);
    public static CANSpark1038 CANSparkRightBack = new CANSpark1038(RIGHT_BACK_PORT, CANSparkMaxLowLevel.MotorType.kBrushless);

    public wheel1(double power) {
        CANSparkRightBack.follow(CANSparkRightFront);
        CANSparkRightFront.set(power);
    }
}