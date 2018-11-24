package proyect.iii.carpooling.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Activity2 extends AppCompatActivity {
    Button button;
        private int _xDelta;
        private int _yDelta;
        private int _rightMargin;
        private int _bottomMargin;
        private ImageView _floatingView;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_2);

            button = (Button) findViewById(R.id.button7);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button.setText("Alajuela");
                }
            });
        }
    }
