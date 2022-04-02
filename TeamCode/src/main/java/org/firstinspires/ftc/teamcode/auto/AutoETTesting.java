package org.firstinspires.ftc.teamcode.auto;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.internal.android.dx.cf.attrib.AttEnclosingMethod;
import org.firstinspires.ftc.teamcode.robot_components.robot.Robot;

import java.util.ArrayList;
import java.util.List;

@Autonomous
public class AutoETTesting extends LinearOpMode {

    //Remember to make the Robot class and make Robot robot import from that one
    Robot robot;

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

        while(opModeIsActive()){
            //got tired of writing runtime.seconds(); :/
            double sec = runtime.seconds();

            //a basic timed turn
            if ((sec >= 3 && sec <= 5) || (sec >= 6 && sec <= 7.2))
                robot.setDriveSpeed(.83);
            if (sec > 5 && sec <= 6)
                robot.turnRight(.83);
                robot.setDriveSpeed(0);


            telemetry.addData( "Timer:", runtime.milliseconds());
            telemetry.addData( "Timer:", runtime.seconds());

            //updates telemetry, don't forget next time
            telemetry.update();

        }
    }
}
