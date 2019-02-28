package com.example.prince.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3,button4,button5;
    int locationofcurrectans;
    TextView editText3,editText5,editText2,editText;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int score=0;
    int ques=0;
    public void generateques(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        editText3.setText(Integer.toString(a)+"+"+Integer.toString(b));
        int incorrectans;
        answers.clear();
        locationofcurrectans=rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==locationofcurrectans){
                answers.add(a+b);
            }
            else
            {
                incorrectans=rand.nextInt(41);
                while(incorrectans==a+b){
                    incorrectans=rand.nextInt(41);
                }
                answers.add(incorrectans);
            }


        }
        button2.setText(Integer.toString(answers.get(0)));
        button3.setText(Integer.toString(answers.get(1)));
        button4.setText(Integer.toString(answers.get(2)));
        button5.setText(Integer.toString(answers.get(3)));

    }
    public void start(View view){
        button.setVisibility(view.INVISIBLE);

    }
   public void chooseans(View view){
        if(view.getTag().toString().equals(Integer.toString(locationofcurrectans))){
        score++;
        editText5.setText("correct!");}
        else{
            editText5.setText("incorrect!");
        }
        ques++;
        editText2.setText(Integer.toString(score)+"/"+Integer.toString(ques));
       generateques();
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);

        editText3=(TextView)findViewById(R.id.editText3);
        editText2=(TextView)findViewById(R.id.editText2);
        editText=(TextView)findViewById(R.id.editText);
        editText5=(TextView)findViewById(R.id.editText5);
       generateques();
        new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                editText.setText(String.valueOf(millisUntilFinished/1000)+"s");

            }

            @Override
            public void onFinish() {
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                editText.setText("0s");
             editText5.setText("your score ="+Integer.toString(score)+"/"+Integer.toString(ques));
            }
        }.start();
    }
}
