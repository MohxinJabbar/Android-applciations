package com.mohsin.bmimeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtView;
        EditText edtWeight, edtHeightFT, edtHeightInch;
        Button btn1Click;
        LinearLayout lMain;

        //assigning variables the id of concerned textview and edit textview and button

        edtWeight = findViewById(R.id.edWeight);
        edtHeightFT = findViewById(R.id.edHeightFt);
        edtHeightInch = findViewById(R.id.edHeightInch);

        txtView = findViewById(R.id.tv1);

        btn1Click = findViewById(R.id.btn1);
        lMain = findViewById(R.id.linearMain);

        //first of all we have to set the onclicklistner() class for button
        //so that whenever we click on button, the code inside the OnclickListner() executed.
        //OnclickListner() is interface class. and there are some abstract methocs in this class,
        // we have to override those abstract methods first. orignally where it is declared only methods are declared. we have to create the
        // -- object of class and then override the interface of OnclickListner(). for overriding hover the mouse on
        //error message and then click Alt+Enter. or simply press the Tab button when suggestion came.

        btn1Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              int wt =  Integer.parseInt(edtWeight.getText().toString()); //Integer.ParseInt() take the string value from edWeight.getText().tostring(); and convert it into Integer.
                int heightFt= Integer.parseInt(edtHeightFT.getText().toString());
                int heightInch = Integer.parseInt(edtHeightInch.getText().toString());
                //we must take care that what kind of  data we take from editText View or any other text view.we must convert it into that relevant data type.
                //otherwise number format exception can be occur.
                if (heightFt < 1 || heightFt > 8) {
                    edtHeightFT.setError("Height should be between 1 and 8 feet.");
                    return;
                }

                if (heightInch < 1 || heightInch > 12) {
                    edtHeightInch.setError("Inches should be between 1 and 12.");
                    return;
                }
                if(wt<1 || wt>200){
                    edtWeight.setError("Too much weight entered..... please recheck your weight");
                return;
                }

                // rest of your code for BMI calculation and setting the result



                //BMI CALCULATION STARTS FROM HERE... FORMULA IS AS UNDER.
                 int totalInches = heightFt*12 + heightInch;
                 //now convert these inches into cm...

                double totalCM= totalInches*2.54;
                //now convert these cm to meters...
                double totalMeters = totalCM/100; // this is the height of body...
                double bmi = wt/Math.pow(totalMeters,2);


                //now check if the body is overweight or underweight...


                if(bmi>25){
                    txtView.setText(getResources().getString(R.string.ov1));
                    lMain.setBackgroundColor(getResources().getColor(R.color.ovColor));

                } else if(bmi<18){
                    txtView.setText(getResources().getString(R.string.uv1));
                    lMain.setBackgroundColor(getResources().getColor(R.color.uvColor));

                } else {
                    txtView.setText(getResources().getString(R.string.hm1));
                    lMain.setBackgroundColor(getResources().getColor(R.color.okColor));

                }





            }
        });


    }
}