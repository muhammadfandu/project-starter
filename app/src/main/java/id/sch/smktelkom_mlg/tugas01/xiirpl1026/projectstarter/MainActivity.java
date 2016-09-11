package id.sch.smktelkom_mlg.tugas01.xiirpl1026.projectstarter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNameProject;
    EditText etDetailProject;
    Spinner spCategories;
    TextView tvResult;

    private void doClick() {
        String name = etNameProject.getText().toString();
        String detail = etDetailProject.getText().toString();

        tvResult.setText("Project " + name + detail);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCategories = (Spinner) findViewById(R.id.spinnerCategories);
        etNameProject = (EditText) findViewById(R.id.editTextName);
        etDetailProject = (EditText) findViewById(R.id.editTextDetail);
        tvResult = (TextView) findViewById(R.id.textViewResult);

        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }
}
