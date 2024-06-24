package com.example.thirdapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Boolean isOperationClick = true;
    private String operator = "";
    private String oldNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void OneNumer(View view) {
        if(isOperationClick){
            textView.setText("");
        }
        isOperationClick = false;

        String number = textView.getText().toString();
        if(view.getId() == R.id.by_9){
            number = number+"9";
        }
        else if(view.getId() == R.id.by_8){
            number = number+"8";
        }
        else if(view.getId() == R.id.by_7){
            number = number+"7";
        }
        else if(view.getId() == R.id.by_6){
            number = number+"6";
        }
        else if(view.getId() == R.id.by_5){
            number = number+"5";
        }
        else if(view.getId() == R.id.by_4){
            number = number+"4";
        }
        else if(view.getId() == R.id.by_3){
            number = number+"3";
        }
        else if(view.getId() == R.id.by_2){
            number = number+"2";
        }
        else if(view.getId() == R.id.by_1){
            number = number+"1";
        }
        else if(view.getId() == R.id.by_0){
            number = number+"0";
        }
        else if(view.getId() == R.id.by_plusminus){
            if(minusIsPresent(number)){
                number = number.substring(1);
            }
            else{
                 number = "-"+number;
            }
        }
        else if(view.getId() == R.id.by_dot){
            if(dotisPresent(number)){
            }
            else{
            number = number+".";
            }
        }
        textView.setText(number);
    }

    public boolean minusIsPresent(String number){
        if(number.charAt(0) == '-'){
            return  true;
        }
        else{
            return false;
        }
    }

    public void OnOperation(View view) {
        isOperationClick = true;
        oldNumber = textView.getText().toString();
        if(view.getId() == R.id.btn_division){
            operator = "/";
        }
        else if(view.getId() == R.id.btn_multi){
            operator = "*";
        }
        else if(view.getId() == R.id.btn_plus){
            operator = "+";
        }
        else if(view.getId() == R.id.btn_minus){
            operator = "-";
        }
    }

    public void OnOperationEquel(View view) {
        String newNumber = textView.getText().toString();
        Double result = 0.0;
        if(operator == "/"){
            result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        }
        else if(operator == "*"){
            result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        }
        else if(operator == "+"){
            result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        }
        else if(operator == "-"){
            result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        }
        textView.setText(result+"");
    }

    public void OneClick(View view) {
        textView.setText("0");
        isOperationClick = true;
    }

    private boolean dotisPresent(String number){
        if(number.indexOf(".") == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public void OnPercent(View view) {

        if(operator == ""){
            String Number = textView.getText().toString();
            Double temp = Double.parseDouble(Number) / 100;
            Number =  temp+"";
            textView.setText(Number);
        }
        else{
            Double result = 0.0;
            String newNumber = textView.getText().toString();
            if(operator == "/"){
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
            }
            else if(operator == "*"){
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
            }
            else if(operator == "+"){
                result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
            }
            else if(operator == "-"){
                result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
            }
            textView.setText(result+"");
        }

    }
}



