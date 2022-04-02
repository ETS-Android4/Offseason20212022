package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class MecExperimental extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");

        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        //if (isStopRequested()) return;

        while (opModeIsActive()) {
            double r = -gamepad1.right_stick_x; // Remember, this is reversed!
            double x = gamepad1.dpad_left ? -1 : gamepad1.dpad_right ? 1 : 0; // Counteract imperfect strafing
            double y = gamepad1.dpad_down ? 1 : gamepad1.dpad_up ? -1 : 0; // google if statement ternery operator if ? and : confusing

            motorFrontLeft.setPower(r + x + y);
            motorBackLeft.setPower(r - x + y);
            motorFrontRight.setPower(r - x - y);
            motorBackRight.setPower(r + x - y);

        }
    }
}
