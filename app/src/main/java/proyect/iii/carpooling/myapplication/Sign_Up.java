package proyect.iii.carpooling.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Sign_Up extends AppCompatActivity {
    Button button;
    RadioGroup rg;
    String lugar="";
    RadioGroup RadioG = (RadioGroup) findViewById(R.id.radio);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);


        EditText name = (EditText) findViewById(R.id.editText3);
        String Nombre = name.getText().toString();
        EditText mail = (EditText) findViewById(R.id.editText5);
        String Correo = mail.getText().toString();
        EditText password = (EditText) findViewById(R.id.editText4);
        String Contra = password.getText().toString();

        button = (Button) findViewById(R.id.b_signup2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

                });
            }





    public String RadioG(){
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId){
                case R.id.radio1:
                lugar=((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                    System.out.println(lugar);
        }
        }
        });
    return lugar;}


    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}