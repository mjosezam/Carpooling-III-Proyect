package proyect.iii.carpooling.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rate extends AppCompatActivity {
    TextView txtrate;

    /**
     * Abre la actividad que califica a los conductores o estudiantes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtrate = (TextView) findViewById(R.id.txtrate);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtrate.setText("Rating: "+rating);
            }
        });
    }
}
