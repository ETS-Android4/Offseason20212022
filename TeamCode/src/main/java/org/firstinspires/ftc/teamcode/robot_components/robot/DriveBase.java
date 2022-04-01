package org.firstinspires.ftc.teamcode.robot_components.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

// Contains the basic code for a mecanum wheel drive base; should be extended by a child Robot class
public class DriveBase {

    // Motor powers
    protected double leftFrontPower = 0;
    protected double rightFrontPower = 0;
    protected double leftRearPower = 0;
    protected double rightRearPower = 0;

    protected double batteryVoltage;

    // Drive speed ranges from 0 to 1
    public double speed = 1;

    // For meta-drive
    // Specifies the direction of meta mode
    // 90 degrees is optimal for when the driver is standing on side of field
    public int metaOffset = 90;

    // Mecanum wheel drive motors
    public DcMotor leftFrontDrive;
    public DcMotor rightFrontDrive;
    public DcMotor leftRearDrive;
    public DcMotor rightRearDrive;

    // For displaying things on the DS phone
    public Telemetry telemetry;
    public HardwareMap hardwareMap;

    public ElapsedTime elapsedTime;

    // Constructs a DriveBase object with four drive motors
    public DriveBase(HardwareMap hardwareMap, Telemetry telemetry) {

        this.hardwareMap = hardwareMap;

        // These are the names to use in the phone config (in quotes below)
        leftFrontDrive = hardwareMap.get(DcMotor.class, "leftFrontDrive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "rightFrontDrive");
        leftRearDrive = hardwareMap.get(DcMotor.class, "leftRearDrive");
        rightRearDrive = hardwareMap.get(DcMotor.class, "rightRearDrive");

        // Default is to have the launcher be the front
        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.FORWARD);

        // Makes the drive motors apply resistance when the power is zero
        leftFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightRearDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initializes telemetry
        this.telemetry = telemetry;

        // For keeping track of time
        elapsedTime = new ElapsedTime();
        elapsedTime.reset();

        batteryVoltage = getBatteryVoltage();
    }

    // Displays drive motor powers on the DS phone
    public void addTelemetryData() {
        telemetry.addData("LF power: ", leftFrontPower);
        telemetry.addData("RF power: ", rightFrontPower);
        telemetry.addData("LR power: ", leftRearPower);
        telemetry.addData("RR power: ", rightRearPower);
        telemetry.update();
    }


    // Finds the current battery voltage
    public double getBatteryVoltage() {
        double result = Double.POSITIVE_INFINITY;
        for (VoltageSensor sensor : hardwareMap.voltageSensor) {
            double voltage = sensor.getVoltage();
            if (voltage > 0) { result = Math.min(result, voltage);
            }
        }
        return result;
    }

    // Sets speed to desired value
    public void setDriveSpeed(double speed) {
        this.speed = speed;
        leftFrontDrive.setPower(speed);
        rightFrontDrive.setPower(speed);
        leftRearDrive.setPower(speed);
        rightRearDrive.setPower(speed);
    }
}