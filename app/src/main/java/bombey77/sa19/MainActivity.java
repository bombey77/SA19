package bombey77.sa19;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final int MENU_CLEAN = 1;
    private final int MENU_EXIT = 2;

    String oper;
    EditText etFirst, etSecond;
    Button btnPlus, btnMinus, btnDevide, btnMultiplay;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etFirst = (EditText)findViewById(R.id.etFirst);
        etSecond = (EditText)findViewById(R.id.etSecond);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnDevide = (Button)findViewById(R.id.btnDevide);
        btnMultiplay = (Button)findViewById(R.id.btnMultiplay);
        tvResult = (TextView)findViewById(R.id.tvResult);

        btnPlus.setOnClickListener(this);
        btnMultiplay.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDevide.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0, MENU_CLEAN, 0, "Clean");
        menu.add(0, MENU_EXIT, 1, "Exit");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == MENU_CLEAN) {
            etFirst.setText("");
            etSecond.setText("");
            tvResult.setText("");
        } else if (id == MENU_EXIT) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        num1 = Float.parseFloat(etFirst.getText().toString());
        num2 = Float.parseFloat(etSecond.getText().toString());

        if(TextUtils.isEmpty(etFirst.getText().toString())
                || TextUtils.isEmpty(etSecond.getText().toString())) {
            return;
        }


        switch (v.getId()) {
            case R.id.btnPlus:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnMinus:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnDevide:
                oper = "/";
                result = num1 / num2;
                break;
            case R.id.btnMultiplay:
                oper = "*";
                result = num1 * num2;
                break;
        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}
