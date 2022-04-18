package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.input.Controller;
import org.firstinspires.ftc.teamcode.robot_components.robot.Gyro;
import org.firstinspires.ftc.teamcode.robot_components.robot.Robot;


@TeleOp
public class TestCalcDrivePowers extends OpMode {
    Robot robot;
    Gyro gyro;
    Controller controller1;
    float x;
    float y;
    float r;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, telemetry);
        gyro = new Gyro(hardwareMap);

        controller1 = new Controller(gamepad1);
        gyro.resetAngle();

        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        x = gamepad1.right_stick_x;
        y = gamepad1.right_stick_y;
        r = gamepad1.left_stick_x;
        if(x != 0 || y != 0 || r != 0)
            robot.calculateDrivePower(x, y, r);
        else
            robot.calculateDrivePower(0,0,0);
        telemetry.addData("Gyro Angles: ", gyro.getAngle());
        telemetry.addData("x", x);
        telemetry.addData("y", y);
        telemetry.addData("r", r);
        telemetry.update();

    }
}