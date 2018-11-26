package proyect.iii.carpooling.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class Log_In extends AppCompatActivity {
    Button button;

    /**
     * Abre la actividad de forma grafica
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);



        button = (Button) findViewById(R.id.b_login2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHighWay();
            }
        });
    }

    /**
     * Abre la actividad principal
     */
    public void openHighWay(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


}
