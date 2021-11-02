package dam.alejandror.u3t1initialapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Atributos
    private int count;
    private String guardar;
    private TextView tvDisplay;
    private Button buttonIncrese, buttonDecrease, buttonReset, buttonIncrese2, buttonDecrease2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI() {
        tvDisplay = findViewById(R.id.tvDisplay);
        buttonIncrese = findViewById(R.id.buttonIncrease);
        buttonIncrese2 = findViewById(R.id.buttonIncrease2);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonDecrease2 = findViewById(R.id.buttonDecrease2);
        buttonReset = findViewById(R.id.buttonReset);

        buttonIncrese.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        buttonIncrese2.setOnClickListener(this);
        buttonDecrease2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonIncrease: count++; break;
            case R.id.buttonDecrease: count--; break;
            case R.id.buttonReset: count=0 ;break;
            //TODO Botones 2+
            case R.id.buttonIncrease2: count+=2;break;
            case R.id.buttonDecrease2: count-=2;break;
        }
        tvDisplay.setText(getString(R.string.number_of_elements) + ": " + count);
    }


    //TODO Save/Restore Instance
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        TextView textView = findViewById(R.id.tvDisplay);
        super.onSaveInstanceState(outState);
        outState.putString(guardar,textView.getText().toString());
    }
    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        TextView textView = findViewById(R.id.tvDisplay);
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            String cadena = savedInstanceState.getString(guardar);
            textView.setText(cadena);
        }
    }
}