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

    Robot robot;
    public ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot = new Robot(hardwareMap, telemetry);

        telemetry.addData("Status", "Initialized");
        //robot.telemetry.update;

        // Waiting for driver to hit PLAY
        waitForStart();

        runtime.reset();
        while(opModeIsActive()){
            if (runtime.seconds() == 5)
                robot.setDriveSpeed(.5);
            if(runtime.seconds() >= 10)
                robot.setDriveSpeed(0);


            telemetry.addData( "Timer:", runtime.milliseconds());
            telemetry.addData( "Timer:", runtime.seconds());
            telemetry.update();
        }
    }
}
