package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import org.mariuszgromada.math.mxparser.*;
import org.w3c.dom.Text;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button  piBTN , exponential_btn , factorial_btn , power_btn , blank_btn , cos_btn , sin_btn ,tan_btn , log_btn , ln_btn , sqrt_btn;
    private TableRow row1 , row2;
    private ImageButton expand_btn;
    private EditText edit_text;
    private TextView textView , result_textview;
    private boolean isResult = false;
    private boolean isINV = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        edit_text = findViewById(R.id.editTextTextPersonName);
        piBTN = findViewById(R.id.pi_button);
        expand_btn = findViewById(R.id.expand_button);
        exponential_btn = findViewById(R.id.exponential_button);
        power_btn = findViewById(R.id.power_button);
        factorial_btn = findViewById(R.id.factorial_btn);
        blank_btn = findViewById(R.id.button34);
        row1 = findViewById(R.id.table_row1);
        row2 = findViewById(R.id.table_row2);
        edit_text.setShowSoftInputOnFocus(false);
        cos_btn = findViewById(R.id.cosine);
        sin_btn = findViewById(R.id.sine);
        tan_btn = findViewById(R.id.tan);
        log_btn = findViewById(R.id.logarithm);
        ln_btn = findViewById(R.id.natural_log);
        sqrt_btn = findViewById(R.id.square_root);
        textView = findViewById(R.id.calculator_textview);
        result_textview = findViewById(R.id.result_textview);

        edit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("edit_text", "onClick: ");
                isResult=false;
                //Toast.makeText(MainActivity.this , "jsfbgjsfn", Toast.LENGTH_SHORT).show();
            }
        });
        edit_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                     Log.d("edit_text", "onClick: ");
                     isResult=false;
              //     Toast.makeText(MainActivity.this , "jsfbgjsfn", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void expand_features(View view) {


        if(piBTN.getVisibility() == View.VISIBLE){
            expand_btn.setImageResource(R.drawable.ic_baseline_expand_less_24);
            piBTN.setVisibility(View.GONE);
            row1.setVisibility(View.GONE);
            row2.setVisibility(View.GONE);
            exponential_btn.setVisibility(View.GONE);
            power_btn.setVisibility(View.GONE);
            factorial_btn.setVisibility(View.GONE);
            blank_btn.setVisibility(View.GONE);
        }else{
            expand_btn.setImageResource(R.drawable.ic_baseline_expand_more_24);
            piBTN.setVisibility(View.VISIBLE);
            exponential_btn.setVisibility(View.VISIBLE);
            row1.setVisibility(View.VISIBLE);
            row2.setVisibility(View.VISIBLE);
            power_btn.setVisibility(View.VISIBLE);
            factorial_btn.setVisibility(View.VISIBLE);
            blank_btn.setVisibility(View.VISIBLE);
        }
    }

    public void all_clear(View view) {

        edit_text.setText("");
        result_textview.setText("");
        textView.setVisibility(View.VISIBLE);
        edit_text.setTextSize(80f);
    }

    public void backspace(View view) {
        int position = edit_text.getSelectionStart();
        String input  = edit_text.getText().toString();
        Log.d("backspace", "backspace: "+ position);
        if(position!= 0 && input.length()!=0){
            String start = input.substring(0,position-1);
            String end =  input.substring(position);
            String result = start + end;
            edit_text.setText(result);
        }if(position>=1){
        edit_text.setSelection(position-1);}

        if(input.length() == 1){
            textView.setVisibility(View.VISIBLE);
            result_textview.setVisibility(View.GONE);
            edit_text.setTextSize(80f);
        }

    }

    public void updateText(String input){
        textView.setVisibility(View.GONE);

        String text  = edit_text.getText().toString();


        if(isResult ){
            int position = edit_text.getSelectionStart();
            edit_text.setText(input);
            edit_text.setTextSize(80f);
            edit_text.setSelection(1);
            result_textview.setVisibility(View.GONE);
            isResult = false;

        }else {
        int position = edit_text.getSelectionStart();
            String start = text.substring(0, position);
            String end = text.substring(position);
            String result = start + input + end;
            edit_text.setText(result);
            edit_text.setSelection(position+1);
        }


//        edit_text.setSelection(position+1);

//        isResult=false;

    }


    public void add_7(View view) {
        updateText("7");
    }

    public void add_8(View view) {
        updateText("8");
    }

    public void add_9(View view) {
        updateText("9");
    }

    public void add_4(View view) {
        updateText("4");
    }

    public void add_5(View view) {
        updateText("5");
    }

    public void add_6(View view) {
        updateText("6");
    }

    public void add_1(View view) {
        updateText("1");
    }

    public void add_2(View view) {
        updateText("2");
    }

    public void add_3(View view) {
        updateText("3");
    }

    public void add_0(View view) {
        updateText("0");
    }


    public void percentage(View view) {
        updateText("%");
    }

    public void add_e(View view) {
        updateText("e");
    }

    public void factorial(View view) {
        updateText("!");
    }

    public void power(View view) {
        updateText("^");
    }

    public void fraction(View view) {
        updateText(".");
    }
    public void add_π(View view) {
        updateText("π");
    }

    public void multiply(View view) {
        updateText("×");
    }
    public void divide(View view) {
        updateText("÷");
    }

    public void subtract(View view) {
        updateText("-");
    }

    public void addition(View view) {
        updateText("+");
    }

    public void sin(View view) {
        if(isINV){
            updateText("asin(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position+4);

        } else {
            updateText("sin(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position + 3);
        }

    }

    public void cosine(View view) {
        if(isINV){
            updateText("acos(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position+4);

        } else {
            updateText("cos(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position + 3);
        }
    }

    public void tan(View view) {
        if(isINV){
            updateText("atan(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position+4);

        } else {
            updateText("tan(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position + 3);
        }    }

    public void bracket_close(View view) {
        updateText(")");
    }

    public void bracket_open(View view) {
        updateText("(");
    }

    public void ln(View view) {
        if(isINV){
            updateText("e^(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position+2);

        } else {
            updateText("ln(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position + 2);
        }    }

    public void log(View view) {
        if(isINV){
            updateText("10^(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position+3);

        } else {
            updateText("log(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position + 3);
        }
    }

    public void square_root(View view) {
        if(isINV){
            updateText("^(2)");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position+3);

        } else {
            updateText("√(");
            int position = edit_text.getSelectionStart();
            edit_text.setSelection(position + 1);
        }
    }

    public void INV(View view) {
        if(isINV==false) {
            isINV = true;
            log_btn.setText(R.string.xPowerYText);
            ln_btn.setText(R.string.eSquaredText);
            sin_btn.setText(R.string.trigArcSinText);
            cos_btn.setText(R.string.trigArcCosText);
            tan_btn.setText(R.string.trigArcTanText);
            sqrt_btn.setText(R.string.xSquaredText);
        }else{
            isINV= false;
            log_btn.setText(R.string.log);
            ln_btn.setText(R.string.ln);
            sin_btn.setText(R.string.sin);
            cos_btn.setText(R.string.cos);
            tan_btn.setText(R.string.tan);
            sqrt_btn.setText(R.string.sqrt);
        }

    }

    public void RAD(View view) {

    }


    public void evaluate(View view) {
        String input = edit_text.getText().toString();
        input = input.replaceAll("÷", "/");
        input = input.replaceAll("×", "*");
        input = input.replaceAll("√", "sqrt");
        input = input.replaceAll("π", "pi");

        Expression expression = new Expression(input);
        if(input.length()==0){

        }else {
            String result = String.valueOf(expression.calculate());
            result_textview.setText(result);
            result_textview.setVisibility(View.VISIBLE);
            edit_text.setTextSize(18f);
//        edit_text.setSelection(result.length());
            isResult = true;
        }

//        if(edit_text.isCursorVisible()){
//            edit_text.setCursorVisible(false);
//        }
//        //

    }




}
