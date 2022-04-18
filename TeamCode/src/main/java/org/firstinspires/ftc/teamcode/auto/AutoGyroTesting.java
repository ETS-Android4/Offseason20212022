package org.firstinspires.ftc.teamcode.auto;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.robot_components.robot.Robot;

import java.util.ArrayList;
import java.util.List;

@Autonomous
public class AutoGyroTesting extends LinearOpMode {

    Robot robot;
//    HardwareMap hardwareMap;
//    Telemetry telemetry;
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap, telemetry);

        telemetry.addData("Status", "Initialized");
        //robot.telemetry.update;

        // Waiting for driver to hit PLAY
        waitForStart();

        //resets the timer everytime before starting the auto
        runtime.reset();

        start();
        //got tired of writing runtime.seconds(); :/
        double sec = runtime.seconds();

        //a basic timed turn
        try {
            wait(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.calculateDrivePower(1,1,0);

        while (opModeIsActive()) {
            telemetry.addData("Timer:", runtime.milliseconds());
            telemetry.addData("Timer:", runtime.seconds());

            //updates telemetry, don't forget next time
            telemetry.update();
        }
        stop();

    }
}
