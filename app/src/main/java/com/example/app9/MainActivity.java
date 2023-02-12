package com.example.app9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    float coat = 70; // пальто
    byte coatDiscount = 77; // cкидка на пальто
    float hat = 25; //шляпа
    byte hatDiscound = 37; // скидка на шляпу
    float suit = 53; // деловой костю
    byte suitDiscound = 44; // скидка на деловой костюм
    float shirt = 19; // сорочка
    byte shirtDiscound = 0; // скидка на сорочку
    float shoes = 41; // туфли
    byte shoesDiscound = 32; // скидка на туфли
    float account;


    private float calc() {
        float count =
                coat * (100 - coatDiscount)/100
                + hat * (100 - hatDiscound)/100
                + suit * (100 - suitDiscound)/100
                + shirt * (100 - shirtDiscound)/100
                + shoes * (100 - shoesDiscound)/100;

        return count;

    }

    private boolean possible(){
        if(calc()<=account){
            return true;

        }else{
            return false;
        }
    }


    private float balance(){
        if(possible()) {
            return account - calc();
        }else{
            return -1;
        }
    }


    private TextView possibleOut, balanceOut;
    private EditText cash;

    private Button check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibleOut = findViewById(R.id.possible);
        balanceOut = findViewById(R.id.balance);
        cash = findViewById(R.id.cash);
        check = findViewById(R.id.check);

        check.setOnClickListener(v -> {
            try {
                account = Float.parseFloat(cash.getText().toString());
                cash.setHint("Ведите количество денег");
            } catch (Exception e) {
                cash.setHint("введи сумму дурак");
                return;
            }

            if(possible()) {
                float change = account-calc();

                possibleOut.setText("Имеется достаточно средств для покупки комплекта");
                balanceOut.setText(String.valueOf(change));
            }else{
                possibleOut.setText("У вас недостаточно средств");
                balanceOut.setText("-");
            }
        });

    }
}