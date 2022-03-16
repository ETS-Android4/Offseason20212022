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

        waitForStart();

        //if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = gamepad1.right_stick_x; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double r = gamepad1.left_stick_y;

            motorFrontLeft.setPower(y + x + r);
            motorBackLeft.setPower(y - x + r);
            motorFrontRight.setPower(y - x - r);
            motorBackRight.setPower(y + x - r);

        }
    }
}
