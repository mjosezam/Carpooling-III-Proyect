package proyect.iii.carpooling.myapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import static java.lang.StrictMath.abs;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    Button button, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, buttontrip;
    TextView to_go;
    boolean flagx=false;

    private int ancho;
    private int alto;

    //Imagen y posición
    private ImageView punto;
    private float puntox;
    private float puntoy;
    public ArrayList<Rect> list = new ArrayList<Rect>();
    ImageView drawingImageView;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    Button buttonx;
    private int _xDelta;
    private int _yDelta;
    private int _rightMargin;
    private int _bottomMargin;
    private ImageView _floatingView;
    private Point puntoInicio;
    private boolean flag = true;

        @SuppressLint("WrongViewCast")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_2);
            punto = (ImageView) findViewById(R.id.punto);




            to_go = findViewById(R.id.to_go);button0 = (Button) findViewById(R.id.buttoncentral);
            button1 = (Button) findViewById(R.id.button1);button2 = (Button) findViewById(R.id.button2);button3 = (Button) findViewById(R.id.button3);
            button4 = (Button) findViewById(R.id.button4);button5 = (Button) findViewById(R.id.button5);button6 = (Button) findViewById(R.id.button6);
            button7 = (Button) findViewById(R.id.button7);button8 = (Button) findViewById(R.id.button8);button9 = (Button) findViewById(R.id.button9);
            button10 = (Button) findViewById(R.id.button10);button11 = (Button) findViewById(R.id.button11);button12 = (Button) findViewById(R.id.button12);
            button13 = (Button) findViewById(R.id.button13);button14 = (Button) findViewById(R.id.button14);button15 = (Button) findViewById(R.id.button15);button16 = (Button) findViewById(R.id.button16);

            button1.setOnClickListener(this);button2.setOnClickListener(this);button3.setOnClickListener(this);button4.setOnClickListener(this);
            button5.setOnClickListener(this);button6.setOnClickListener(this);button7.setOnClickListener(this);button8.setOnClickListener(this);
            button9.setOnClickListener(this);button10.setOnClickListener(this);button11.setOnClickListener(this);button12.setOnClickListener(this);
            button13.setOnClickListener(this);button14.setOnClickListener(this);button15.setOnClickListener(this);button16.setOnClickListener(this);

            setButtonNames();


            buttontrip = findViewById(R.id.buttontrip);
            buttontrip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttontrip.setVisibility(View.INVISIBLE);
                    button16.post( new Runnable() {
                        //1,2,6,7,10
                        Button boton1;
                        Button boton2;

                        @Override
                        public void run() {
                            for(int i = 0;i<3;i++){
                                if (i ==0){
                                    boton1=button1;
                                    boton2 = button0;
                                    puntoInicio = startPoint(boton1);//Punto de inicio
                                    Point size = new Point();
                                    WindowManager wm = getWindowManager();
                                    Display disp = wm.getDefaultDisplay();
                                    disp.getSize(size);
                                    ancho = size.x+500;
                                    alto = size.y;
                                    puntox=puntoInicio.x;
                                    puntoy=puntoInicio.y;
                                    Log.d("Activity2", "onCreate: "+puntoInicio.x+"WAJOx"+puntoInicio.y);
                                    timer.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            handler.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    changePos(/*but16*/boton2);//Llegada
                                                }
                                            });
                                        }
                                    }, 1000, 20);
                                }
                            }

                        }

                    });
                }
            });





}

    public Point startPoint(Button start){
        Point puntoInicio = new Point((int)start.getX()-160,(int)start.getY()-200);
        Log.d("PTOw", "startPoint: "+start.getY());
        return puntoInicio;
    }


    public void changePos(Button puntoFinal){//Mover en y
        if (flag) {
            if ((abs(puntox-(puntoFinal.getX()-160))>10)||(abs(puntoy-(puntoFinal.getY())-200)>10||abs(puntoy-(puntoFinal.getY())+200)>10)){
                flag= false;
            }
            else{
                puntox=puntoInicio.x;
                puntoy=puntoInicio.y;
            }
        }
        if (!flag) {
            if (abs(puntox - (puntoFinal.getX() - 160)) > 10) {
                if (puntox - (puntoFinal.getX() - 160) > 0) {
                    puntox -= 10;
                } else {
                    puntox += 10;
                }
            } else if (abs(puntoy - (puntoFinal.getY()) - 200) > 10 || abs(puntoy - (puntoFinal.getY()) + 200) > 10) {
                if (puntoy - (puntoFinal.getY() - 200) > 0) {
                    puntoy -= 10;
                } else {
                    puntoy += 10;
                }
            }
            punto.setX(puntox);
            punto.setY(puntoy);
        }
        flag=true;
    }

    public void setButtonNames() {
        String[] lugares = {"Dulce Nombre", "Occidental", "Oriental", "El Tejar", "El Guarco", "Tierra Blanca", "Carmen", "Guadalupe",
                "San Nicolas", "Agua Caliente", "Turrialba", "Tucurrique", "Concepcion", "San Rafael", "Cot", "Pacayas", "Cervantes"};
        Button[] botones = {button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11
                , button12, button13, button14, button15, button16};
        int value;
        Random random = new Random();
        int[] numerosUsados = new int[32];
        for (int i = 0; i < 32; i++) {
            value = random.nextInt(16);
            for (int j = 0; j < 16; j++) {
                if (value == numerosUsados[j]) {
                    value = random.nextInt(16);
                }
            }
            numerosUsados[i] = value;
            botones[value].setText(lugares[value]);
        }
    }

    public void openThis(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        System.out.println("DIRECTION");
            switch (v.getId()){
                case R.id.button1:
                    to_go.setText(button1.getText());
                    break;
                case R.id.button2:
                    to_go.setText(button2.getText());
                    break;
                case R.id.button3:
                    to_go.setText(button3.getText());
                    break;
                case R.id.button4:
                    to_go.setText(button4.getText());
                    break;
                case R.id.button5:
                    to_go.setText(button5.getText());
                    break;
                case R.id.button6:
                    to_go.setText(button6.getText());
                    break;
                case R.id.button7:
                    to_go.setText(button7.getText());
                    break;
                case R.id.button8:
                    to_go.setText(button8.getText());
                    break;
                case R.id.button9:
                    to_go.setText(button9.getText());
                    break;
                case R.id.button10:
                    to_go.setText(button10.getText());
                    break;
                case R.id.button11:
                    to_go.setText(button11.getText());
                    break;
                case R.id.button12:
                    to_go.setText(button12.getText());
                    break;
                case R.id.button13:
                    to_go.setText(button13.getText());
                    break;
                case R.id.button14:
                    to_go.setText(button14.getText());
                    break;
                case R.id.button15:
                    to_go.setText(button15.getText());
                    break;
                case R.id.button16:
                    to_go.setText(button16.getText());
                    break;
            }
    }

}
