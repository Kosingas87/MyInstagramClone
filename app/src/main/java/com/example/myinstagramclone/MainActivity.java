package com.example.myinstagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText edtName;
    private EditText edtPunchSpeed;
    private EditText edtPunchPower;
    private EditText edtKickPower;
    private EditText edtKickSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        btnSave= findViewById(R.id.btnSave);
        edtName=findViewById(R.id.edtName);
        edtPunchSpeed=findViewById(R.id.edtPunchSpeed);
        edtPunchPower=findViewById(R.id.edtPunchPower);
        edtKickPower=findViewById(R.id.edtKickPower);
        edtKickSpeed=findViewById(R.id.edtKickSpeed);
        btnSave.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        try {
            final ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("name", edtName.getText().toString());
            kickBoxer.put("punchSpeed", Integer.parseInt(edtPunchSpeed.getText().toString()));
            kickBoxer.put("punchPower", Integer.parseInt(edtPunchPower.getText().toString()));
            kickBoxer.put("kickSpeed", Integer.parseInt(edtKickSpeed.getText().toString()));
            kickBoxer.put("kickPower", Integer.parseInt(edtKickPower.getText().toString()));
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(MainActivity.this, "Kickboxer is saved: " + kickBoxer.get("name"), FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();
                    } else {
                        FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }

                }
            });

        } catch (Exception e){
            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
        
        }
    }


        }

//    public void helloWorldTapped(View view) {
////        Log.i("STRING", "TAPPED");
////        ParseObject boxer = new ParseObject("Boxer");
////        boxer.put("punch_speed",200);
////        boxer.saveInBackground(new SaveCallback() {
////            @Override
////            public void done(ParseException e) {
////                Log.i("this","Greska postoji");
////                if(e==null){
////                    Log.i("this","Greska jok");
////                    Toast.makeText(MainActivity.this,"boxer object is saved succesfully", Toast.LENGTH_LONG).show();
////                }
////            }
////        });
//        try {
//
//
//            ParseObject kickBoxer = new ParseObject("KickBoxer");
//            kickBoxer.put("name", "John");
//            kickBoxer.put("punchSpeed", 1000);
//            kickBoxer.put("punchPower", 2000);
//            kickBoxer.put("kickSpeed", 3000);
//            kickBoxer.put("kickPower", 4000);
//            kickBoxer.saveInBackground(new SaveCallback() {
//                @Override
//                public void done(ParseException e) {
//                    Toast.makeText(MainActivity.this, "Kick is saved", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//        } catch (Exception e){
//            Toast.makeText(MainActivity.this, "Greska"+e, Toast.LENGTH_SHORT).show();
//        }
//    }

