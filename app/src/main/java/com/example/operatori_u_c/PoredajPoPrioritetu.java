package com.example.operatori_u_c;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class PoredajPoPrioritetu extends AppCompatActivity {
    private TableLayout tabla;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poredaj_po_prioritetu);
        tabla=(TableLayout) findViewById(R.id.tablaa);
        but=(Button) findViewById(R.id.button_confirm);
        but.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
               tabla.setClickable(false);
                tabla.setContextClickable(false);
            }
        });
    }
}
