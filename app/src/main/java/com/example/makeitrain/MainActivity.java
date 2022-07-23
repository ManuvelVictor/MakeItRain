package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public Button makeItRain;
//    public Button showInfo;
    public TextView moneyValue;
    public TextView HiddenTV;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.buttonMakeItRain);
        moneyValue = findViewById(R.id.moneyViewTV);

    }

    @SuppressLint("ResourceAsColor")
    public void showMoney(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyValue.setText(numberFormat.format(moneyCounter));
//        Log.d("MIR", "OnClick: " + moneyCounter);\
        TextView hiddenTV = findViewById(R.id.hiddentextView);
        hiddenTV.setVisibility(View.INVISIBLE);

        switch (moneyCounter) {
            case 20000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white));
                hiddenTV.setVisibility(View.VISIBLE);
                hiddenTV.setText(R.string.hiddenTV);
                break;
            case 30000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.dark_red));
                hiddenTV.setVisibility(View.VISIBLE);
                hiddenTV.setText(R.string.hiddenTV);
                break;
            default:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        }
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_SHORT).show();

        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_SHORT)
                .setAction("More", view1 -> Log.d("Snack", "showInfo : Snackbar More"))
                .show();
    }
}