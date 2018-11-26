package proyect.iii.carpooling.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Activity2 extends AppCompatActivity {
    Button button;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_2);

            button = (Button) findViewById(R.id.button7);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("1");
                    open();
                    System.out.println("2");
                }
            });
        }

    public void open(){
        Intent intent = new Intent(this, Rate.class);
        startActivity(intent);
    }
    }
