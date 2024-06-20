package com.sidhant.multi_screen_app;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.Key;

public class MainActivity extends AppCompatActivity {
    public static final String KEY="com.example.Multi_Screen_App.KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




//        Button click=findViewById(R.id.btnorder);
//        click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent =new Intent(getApplicationContext(),Revieworder.class);
//                startActivity(intent);
//            }
//        });


        Button orderbtnn=findViewById(R.id.btnorder);
        final EditText et1=findViewById(R.id.Text1);
        final EditText et2=findViewById(R.id.Text2);
        final EditText et3=findViewById(R.id.Text3);

        orderbtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String orderplaced=et1.getText().toString()+" "+ et2.getText().toString()+" "+et3.getText().toString();
                Intent intent=new Intent(getApplicationContext(),Revieworder.class);
                intent.putExtra(KEY,orderplaced);
                startActivity(intent);
            }
        });
    }
}