package com.slamtec.rotationaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.slamtec.slamware.AbstractSlamwarePlatform;
import com.slamtec.slamware.action.ActionStatus;
import com.slamtec.slamware.action.IMoveAction;
import com.slamtec.slamware.discovery.DeviceManager;
import com.slamtec.slamware.exceptions.ConnectionFailException;
import com.slamtec.slamware.exceptions.ConnectionTimeOutException;
import com.slamtec.slamware.exceptions.InvalidArgumentException;
import com.slamtec.slamware.exceptions.OperationFailException;
import com.slamtec.slamware.exceptions.ParseInvalidException;
import com.slamtec.slamware.exceptions.RequestFailException;
import com.slamtec.slamware.exceptions.UnauthorizedRequestException;
import com.slamtec.slamware.exceptions.UnsupportedCommandException;
import com.slamtec.slamware.robot.MoveOption;
import com.slamtec.slamware.robot.Rotation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private IMoveAction action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AbstractSlamwarePlatform robotPlatform = DeviceManager.connect("192.168.11.1", 1445);

        Button buttonClockwise = (Button) findViewById(R.id.button_clockwise);

        Button buttonAnticlockwise = (Button) findViewById(R.id.button_anticlockwise);

        buttonClockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    action = robotPlatform.rotate(new Rotation(setPI(90), 0, 0));
                //    action.waitUntilDone();
                    Log.d(TAG, "Clockwise Rotate 90");
                } catch (RequestFailException e) {
                    e.printStackTrace();
                } catch (ConnectionFailException e) {
                    e.printStackTrace();
                } catch (ConnectionTimeOutException e) {
                    e.printStackTrace();
                } catch (UnauthorizedRequestException e) {
                    e.printStackTrace();
                } catch (UnsupportedCommandException e) {
                    e.printStackTrace();
                } catch (ParseInvalidException e) {
                    e.printStackTrace();
                } catch (InvalidArgumentException e) {
                    e.printStackTrace();
                } catch (OperationFailException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonAnticlockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    action = robotPlatform.rotate(new Rotation(setPI(-90), 0, 0));
                //    action.waitUntilDone();
                    Log.d(TAG, "Anticlockwise Rotate 90");
                } catch (RequestFailException e) {
                    e.printStackTrace();
                } catch (ConnectionFailException e) {
                    e.printStackTrace();
                } catch (ConnectionTimeOutException e) {
                    e.printStackTrace();
                } catch (UnauthorizedRequestException e) {
                    e.printStackTrace();
                } catch (UnsupportedCommandException e) {
                    e.printStackTrace();
                } catch (ParseInvalidException e) {
                    e.printStackTrace();
                } catch (InvalidArgumentException e) {
                    e.printStackTrace();
                } catch (OperationFailException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    private float setPI(int i) {
        return (float)(i*Math.PI/180);
    }
}
