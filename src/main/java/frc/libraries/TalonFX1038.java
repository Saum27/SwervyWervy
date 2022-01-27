package frc.libraries;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

// import edu.wpi.first.wpilibj.;

public class TalonFX1038 extends TalonFX {
    public TalonFX1038(int address) {
        super(address);
    }

    public void pidWrite(double output) {
        set(output);
    }

    public void set(double speed) {
        super.set(super.getControlMode(), speed);
    }

    public double get() {
        return super.getMotorOutputPercent();
    }

    @Override
    public void setInverted(boolean isInverted) {
        super.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return super.getInverted();
    }

    public void disable() {
        super.set(super.getControlMode(), 0);
    }

    public void stopMotor() {
        super.set(super.getControlMode(), 0);
    }

    public double getPosition() {
        return super.getSelectedSensorPosition();
    }

    public void setPosition(int i) {
        super.setSelectedSensorPosition(i);
    }

    public void resetPosition() {
        setPosition(0);
    }

    public double getRotations() {
        return getPosition() / 360;
    }
}
