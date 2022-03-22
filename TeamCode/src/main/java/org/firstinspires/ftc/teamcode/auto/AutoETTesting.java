package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.robot.Robot;

@Autonomous
public class AutoETTesting extends LinearOpMode {

    //private Robot robot = new Robot(hardwareMap, telemetry;);

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");

        // Waiting for driver to hit PLAY
        waitForStart();


    }
}
