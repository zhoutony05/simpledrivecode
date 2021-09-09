package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Drivetrain extends SubsystemBase {
  private final TalonSRX leftMotor1 = new TalonSRX(Constants.leftMotor1ID);
  //private final WPI_TalonFX leftMotor2 = new WPI_TalonFX(Constants.leftMotor2ID);
  private final TalonSRX rightMotor1 = new TalonSRX(Constants.rightMotor1ID);
  //private final WPI_TalonFX rightMotor2 = new WPI_TalonFX(Constants.rightMotor1ID);


  private double leftPower = 0;
  private double rightPower = 0;

  public Drivetrain() {
    rightMotor1.setInverted(true);
  }

  public void arcadeDrive(double throttle, double turn){
    //turn is positive=>left motor increases=>turns right
    leftPower = throttle + turn; 
    rightPower = throttle - turn;
  }

  @Override
  public void periodic() {
    leftMotor1.set(ControlMode.PercentOutput, leftPower);
    rightMotor1.set(ControlMode.PercentOutput, rightPower);
  }
}