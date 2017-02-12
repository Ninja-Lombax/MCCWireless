package net.androidbootcamp.mccwireless;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    double cellPrice = 0.00;
    double unlTextPrice = 10.00;
    double unlDataPrice = 15.00;
    double SamsungPhonePrice = 50.00;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RadioButton unlTxt = (RadioButton) findViewById(R.id.radUnlTxt);
        final RadioButton unlData = (RadioButton) findViewById(R.id.radData);
        final RadioButton SamsungPhone = (RadioButton) findViewById(R.id.radSamsungPhone);
        final TextView result = (TextView) findViewById(R.id.txtTotal);
        Button submit = (Button) findViewById(R.id.btnSubmit);
        Button updatePrice = (Button) findViewById(R.id.btnUpdateP);
        Button reset = (Button) findViewById(R.id.btnReset);

        updatePrice.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                cellPrice = 10.00;
                DecimalFormat totalPriceFormat = new DecimalFormat("$#.00");

                if(unlTxt.isChecked())
                {
                    cellPrice += unlTextPrice;
                }
                if(unlData.isChecked())
                {
                    cellPrice += unlDataPrice;

                }
                if(SamsungPhone.isChecked())
                {
                    cellPrice += SamsungPhonePrice;

                }
               result.setText(totalPriceFormat.format(cellPrice) + " is your total per month");

            }


        });

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, OfferAccepted.class));
            }
        });

        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                unlTxt.setChecked(false);
                unlData.setChecked(false);
                SamsungPhone.setChecked(false);
                result.setText("");

                Toast.makeText(MainActivity.this, "The offer has been reset.", Toast.LENGTH_SHORT).show();
            }




        });






    }
}
