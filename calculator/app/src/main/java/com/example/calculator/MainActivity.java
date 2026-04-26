package com.example.calculator;

import android.os.Bundle; import android.view.View;
import android.widget.Button; import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvResult;
    double num1 = 0, num2 = 0, result = 0;
    String operator = "";
    boolean newOp = false;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        int[] ids = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
                R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv,
                R.id.btnEq,R.id.btnC};
        for (int id : ids) findViewById(id).setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        Button b = (Button) v;
        String txt = b.getText().toString();
        switch (txt) {
            case "C": tvResult.setText("0"); num1=num2=0; operator=""; break;
            case "+": case "-": case "*": case "/":
                num1 = Double.parseDouble(tvResult.getText().toString());
                operator = txt; newOp = true; break;
            case "=":
                num2 = Double.parseDouble(tvResult.getText().toString());
                switch(operator){
                    case "+": result = num1+num2; break;
                    case "-": result = num1-num2; break;
                    case "*": result = num1*num2; break;
                    case "/": result = (num2!=0)?num1/num2:0; break;
                }
                tvResult.setText(String.valueOf(result)); newOp=true; break;
            default:
                if (newOp) { tvResult.setText(txt); newOp=false; }
                else { String cur=tvResult.getText().toString();
                    tvResult.setText(cur.equals("0")?txt:cur+txt); }
        }
    }
}
