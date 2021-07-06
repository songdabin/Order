package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    private EditText americano, latte, mocha;
    private CheckBox chk_discount;
    private TextView num, discount, total;
    private int ame, lat, moc;
    private int n, dc, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        americano = findViewById(R.id.americano);
        latte = findViewById(R.id.latte);
        mocha = findViewById(R.id.mocha);
        chk_discount = findViewById(R.id.chk_discount);
        num = findViewById(R.id.num);
        discount = findViewById(R.id.discount);
        total = findViewById(R.id.total);
    }

    public void cal(View view) {
        ame = parseInt(americano.getText().toString());
        lat = parseInt(latte.getText().toString());
        moc = parseInt(mocha.getText().toString());
        if (view.getId() == R.id.bnt_cal) {
            n = ame + lat + moc;
            sum = (1000 * ame) + (1500 * lat) + (1700 * moc);
            dc = 0;
            if (chk_discount.isChecked()) {
                dc = (int) ((1000 * ame + 1500 * lat + 1700 * moc) * 0.1);
                sum -= dc;
            }
            num.setText("주문개수 : " + n + "개");
            discount.setText("할인금액 : " + dc + "원");
            total.setText("결제금액 : " + sum + "원");
        }
    }
}