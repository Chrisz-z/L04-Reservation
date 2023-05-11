package sg.edu.rp.c346.id22035357.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNum;
    EditText etGsize;
    DatePicker Dp;
    TimePicker Tp;
    RadioButton rbSmoke;
    RadioButton rbNonsmoke;
    Button btnRegi;
    Button btnReset;
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etNum   = findViewById(R.id.etNum);
        etGsize = findViewById(R.id.etGsize);
        Dp = findViewById(R.id.DP1);
        Tp = findViewById(R.id.TP1);
        rbSmoke = findViewById(R.id.rbsmoke);
        rbNonsmoke =findViewById(R.id.rbNonsmoke);
        btnRegi = findViewById(R.id.btnBook);
        btnReset =  findViewById(R.id.btnReset);
        tvDisplay = findViewById(R.id.tvDisplay);

        Dp.updateDate(2020,6,1);
        Tp.setCurrentHour(19);
        Tp.setCurrentMinute(30);
        btnRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Smoke = "Non-Smoking Area";
                String name= "";
                String Num = "";
                String size = "";
                if(rbSmoke.isChecked()){
                    Smoke = "Smoking-Area";
                }
                if (etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Invalid Name",Toast.LENGTH_LONG).show();
                }else if(etNum.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Invalid Number",Toast.LENGTH_LONG).show();
                } else if (etGsize.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"Invalid Group size",Toast.LENGTH_LONG).show();
                }else{
                    name= etName.getText().toString();
                    Num = etNum.getText().toString();
                    size = etGsize.getText().toString();
                    Toast.makeText(MainActivity.this,"Registration Success",Toast.LENGTH_LONG).show();
                    String text = "Name: "+name+"\n"+
                            "Contact Number: "+ Num +"\n"+
                            "Group size: "+size+"\n"+
                            "Sitting Area: " + Smoke +"\n"+
                            "Date: " + Dp.getDayOfMonth()+"/"+Dp.getMonth()+"/"+Dp.getYear()+"\n"+
                            "Time: " + Tp.getCurrentHour() + ":" + Tp.getCurrentMinute();
                    tvDisplay.setText(text);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dp.updateDate(2020,6,1);
                Tp.setCurrentHour(19);
                Tp.setCurrentMinute(30);
                etName.setText("");
                etGsize.setText("");
                etNum.setText("");
                rbNonsmoke.setChecked(true);
                tvDisplay.setText("");
            }
        });
        Tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(Tp.getCurrentHour()<8 || Tp.getCurrentHour()>=21){
                    Toast.makeText(MainActivity.this,"Reservation time is only between 8AM and 8:59PM inclusive",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}