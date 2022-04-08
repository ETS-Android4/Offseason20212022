package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.input.Btn;
import org.firstinspires.ftc.teamcode.input.Controller;
import org.firstinspires.ftc.teamcode.robot_components.robot.Robot;

@TeleOp
public class MecExperimental extends LinearOpMode{

    BNO055IMU imu;
    Orientation angles;
    Robot robot;
    Controller controller1;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new Robot(hardwareMap, telemetry);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        controller1 = new Controller(gamepad1); // Whoever presses start + a

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        //if (isStopRequested()) return;

        while (opModeIsActive()) {
            controller1.update();
            //gyro
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            telemetry.addData("Heading", angles.firstAngle);
            telemetry.addData("Roll", angles.secondAngle);
            telemetry.addData("Pitch", angles.thirdAngle);
            telemetry.update();

            //drive controls
            double r = controller1.left_stick_x; // Remember, this is reversed!
            double x = -controller1.left_stick_y; // Counteract imperfect strafing
            double y = controller1.right_stick_x; // google if statement ternery operator if ? and : confusing
            telemetry.addData("rightstick", controller1.right_stick_x);

            robot.leftFrontDrive.setPower(r + x + y);
            robot.leftRearDrive.setPower(r - x + y);
            robot.rightFrontDrive.setPower(r - x - y);
            robot.rightRearDrive.setPower(r + x - y);

            boolean goSpin = controller1.a == (Btn.PRESSED);
            if (goSpin){
                robot.turn(1);
            }

        }
    }
}
