package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean Newopp = true;
    EditText ed1;
    String opp = "+";
    String oldNumber = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(Newopp)
        {
            ed1.setText("");
        }
        Newopp = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.btn_zero:
                number += "0";
                break;
            case R.id.btn_dot:
                number += ".";
                break;
            case R.id.btn_one:
                number += "1";
                break;
            case R.id.btn_two:
                number += "2";
                break;
            case R.id.btn_three:
                number += "3";
                break;
            case R.id.btn_four:
                number += "4";
                break;
            case R.id.btn_five:
                number += "5";
                break;
            case R.id.btn_six:
                number += "6";
                break;
            case R.id.btn_seven:
                number += "7";
                break;
            case R.id.btn_eight:
                number += "8";
                break;
            case R.id.btn_nine:
                number += "9";
                break;
            case R.id.btn_plusminus:
                number = "-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        Newopp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.btn_add: opp = "+";
            case R.id.btn_divide: opp = "/";
            case R.id.btn_subtract: opp = "-";
            case R.id.btn_multiply: opp = "*";
        }
    }

    public void resultEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (opp){
            case "+":
                result = Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
            case "-":
                result = Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
            case "/":
                result = Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);

        }
        ed1.setText(result+"");
    }

    public void clearScreen(View view) {
        ed1.setText("0");
        Newopp = true;
    }

    public void PercentEvent(View view) {
        double no = Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        Newopp = true;
    }

    @SuppressLint("SetTextI18n")
    public void func_facto(View view) {
        double facto = Double.parseDouble(ed1.getText().toString());
        if(facto == 0 || facto == 1){
            ed1.setText("1");
        }else{
            if(facto<0){
                ed1.setText("ERROR");
            }else{
                int i, fact=1;
                for(i=1;i<=facto;i++){
                    fact = fact*i;
                }
                ed1.setText(fact+"");
            }
        }
    }

    public void func_square_root(View view) {
        double ans = Double.parseDouble(ed1.getText().toString());
        ed1.setText(Math.sqrt(ans)+"");
    }

    public void func_cube_root(View view) {
        double ans = Double.parseDouble(ed1.getText().toString());
        ed1.setText(Math.cbrt(ans)+"");
    }

    public void func_sin(View view) {
        double ans = Math.sin(Double.parseDouble(ed1.getText().toString()));
        ed1.setText( Math.toDegrees(ans)+"");
    }

    public void func_cos(View view) {
        double ans = Math.cos(Double.parseDouble(ed1.getText().toString()));
        ed1.setText( Math.toDegrees(ans)+"");
    }

    public void func_tan(View view) {
        double ans = Math.tan(Double.parseDouble(ed1.getText().toString()));
        ed1.setText( Math.toDegrees(ans)+"");
    }

    public void power10(View view) {
        double ans = Double.parseDouble(ed1.getText().toString());
        int p=10;
        if(ans == 0){
            ed1.setText(1+"");
        }else{
            if(ans==1){
                ed1.setText(10+"");
            }else{
                for(int i=2;i<=ans;i++){
                    p = p*10;
                }
                ed1.setText(p+"");
            }
        }

    }
}

