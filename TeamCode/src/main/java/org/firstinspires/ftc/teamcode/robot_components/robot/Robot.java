package org.firstinspires.ftc.teamcode.robot_components.robot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// Robot class with more functionality than just the DriveBase
// Contains all of the motors/servos/sensors specific to this year's challenge
public class Robot extends DriveBase {

    // Robot variables and objects

    // Constructs a robot with the mechanical functions specific to this year's competition
    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {

        super(hardwareMap, telemetry); // Calls the DriveBase constructor, which handles drive motors
    }

    public void turnRight(double speed) {
        this.speed = speed;
        leftFrontDrive.setPower(speed);
        rightFrontDrive.setPower(-speed);
        leftRearDrive.setPower(speed);
        rightRearDrive.setPower(-speed);
    }

    public void turnLeft(double speed) {
        this.speed = speed;
        leftFrontDrive.setPower(-speed);
        rightFrontDrive.setPower(speed);
        leftRearDrive.setPower(-speed);
        rightRearDrive.setPower(speed);
    }

    public void turn(double speed) {
        this.speed = speed;
        leftFrontDrive.setPower(speed);
        rightFrontDrive.setPower(-leftFrontPower);
        leftRearDrive.setPower(speed);
        rightRearDrive.setPower(-leftRearPower);
    }

    /**
     * Toggle the extension between extended to a given length or retracted. Expects extenderMotor
     * to be set up properly with RunMode.RUN_TO_POSITION.
     * todo what unit of measurement is distance????? Gonna assume that it is in mm
     * @param distance The distance to extend to if retracted.
     */
}

