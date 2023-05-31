package com.example.txon_test_03;

import static android.graphics.Color.MAGENTA;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{
    TextView totalquestions;
    TextView textView;
    Button b1,b2,b3,b4;
    Button button;
    int score=0;
    int totalquestionss=questionanswer.question.length;
    int currentindex=0;
    String selectedanswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        totalquestions=findViewById(R.id.textView);
        textView=findViewById(R.id.textView2);
        b1=findViewById(R.id.ansA);
        b2=findViewById(R.id.ansB);
        b3=findViewById(R.id.ansC);
        b4=findViewById(R.id.ansD);
        button=findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        button.setOnClickListener(this);
        totalquestions.setText("Total Questions:"+totalquestionss);
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if(currentindex==totalquestionss)
        {
            finishquiz();
            return;
        }
        textView.setText(questionanswer.question[currentindex]);
        b1.setText(questionanswer.Answer[currentindex][0]);
        b2.setText(questionanswer.Answer[currentindex][1]);
        b3.setText(questionanswer.Answer[currentindex][2]);
        b4.setText(questionanswer.Answer[currentindex][3]);
    }

    private void finishquiz() {
        String passstatus="";
        new AlertDialog.Builder(this)
         .setTitle(passstatus)
                .setMessage("score : "+score+"/"+totalquestionss)
        .setPositiveButton("Restart",((dialogInterface, i) -> restartquiz()))
                .setCancelable(false)
        .show();



    }

    private void restartquiz() {
        score=0;
        currentindex=0;
        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        b1.setBackgroundColor(Color.WHITE);
        b2.setBackgroundColor(Color.WHITE);
        b3.setBackgroundColor(Color.WHITE);
        b4.setBackgroundColor(Color.WHITE);

     Button button1=(Button) view;
     if( button1.getId()==R.id.button3)
        {

            if(selectedanswer.equals(questionanswer.correctAnswer[currentindex]))
            {
                score++;
            }
            currentindex++;

            loadNewQuestion();
        }else
        {
            selectedanswer=button1.getText().toString();
            if(selectedanswer.equals(questionanswer.correctAnswer[currentindex]))
            {

                button1.setBackgroundColor(Color.GREEN);

            }
            else {
                button1.setBackgroundColor(Color.RED);
            }

        }



    }
}