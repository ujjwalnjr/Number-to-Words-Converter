package com.ujjwal.numtowordconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText num_val;
   private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num_val = findViewById(R.id.et_num);
        output = findViewById(R.id.result);
    }

    public void convert_num(View view) {
        String num_value = num_val.getText().toString().trim();

        if (num_value.isEmpty()){
            num_val.setError("Please enter a 3 digit number");
        }
        else {
            Num nbr = new Num(Integer.parseInt(num_value));
            output.setText(numToWord(nbr.getNumber()));
        }
    }

    private String numToWord(int num) {
        String[] oneToNineteen = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
                " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

        String[] tenToNinety = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

        String word;

        if (num == 0) {
            word = "Zero";
        } else if (num < 20) {
            word = oneToNineteen[num];
        } else if (num >= 20 && num < 100) {
            word = tenToNinety[num / 10] + oneToNineteen[num % 10];
        } else {
            int rem = num % 100;
            if (rem == 0) {
                word = oneToNineteen[num / 100] + " Hundred";
            } else {
                word = oneToNineteen[num / 100] + " Hundred and" + (rem < 20 ? oneToNineteen[rem] : tenToNinety[rem / 10] + oneToNineteen[rem % 10]);
            }
        }
        return word;
    }

}
