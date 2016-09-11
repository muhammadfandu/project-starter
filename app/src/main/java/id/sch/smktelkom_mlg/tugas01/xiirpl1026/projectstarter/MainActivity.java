package id.sch.smktelkom_mlg.tugas01.xiirpl1026.projectstarter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNameProject;
    EditText etDetailProject;
    Spinner spCategories;
    RadioButton rbIn, rbGr;
    CheckBox cbSA, cbSP, cbFP;
    TextView tvResult;

    private boolean isValid() {
        String name = etNameProject.getText().toString();
        String detail = etDetailProject.getText().toString();
        String spinner = spCategories.getSelectedItem().toString();
        String radioresult = null;

        boolean valid = true;

        if (rbIn.isChecked()) {
            radioresult = rbIn.getText().toString();
        } else if (rbGr.isChecked()) {
            radioresult = rbGr.getText().toString();
        }

        if (radioresult == null) {
            rbGr.setError("Type not specified");
            rbIn.setError("Type not specified");
            valid = false;
        }

        String checkboxresult = "";
        int startlen = checkboxresult.length();
        if (cbSA.isChecked()) checkboxresult += cbSA.getText() + "\n";
        if (cbSP.isChecked()) checkboxresult += cbSP.getText() + "\n";
        if (cbFP.isChecked()) checkboxresult += cbFP.getText() + "\n";

        if (checkboxresult.length() == startlen) {
            cbSA.setError("Project intent not specified");
            cbSP.setError("Project intent not specified");
            cbFP.setError("Project intent not specified");
            valid = false;
        }

        if (name.isEmpty()) {
            etNameProject.setError("Project name not specified");
            valid = false;
        } else {
            etNameProject.setError(null);
        }

        if (detail.isEmpty()) {
            etDetailProject.setError("Project Description not specified");
            valid = false;
        } else {
            etDetailProject.setError(null);
        }

        return valid;
    }

    private void doClick() {
        String name = etNameProject.getText().toString();
        String detail = etDetailProject.getText().toString();
        String radioresult = null;

        if (rbIn.isChecked()) {
            radioresult = rbIn.getText().toString();
        } else if (rbGr.isChecked()) {
            radioresult = rbGr.getText().toString();
        }

        if (radioresult == null) {
            radioresult = "Type not specified";
        }

        String checkboxresult = "";
        int startlen = checkboxresult.length();
        if (cbSA.isChecked()) checkboxresult += cbSA.getText() + "\n";
        if (cbSP.isChecked()) checkboxresult += cbSP.getText() + "\n";
        if (cbFP.isChecked()) checkboxresult += cbFP.getText() + "\n";

        if (checkboxresult.length() == startlen) checkboxresult += "No intent made";

        StringBuilder builder = new StringBuilder();
        builder.append("\nProject name\n");
        builder.append(etNameProject.getText().toString());
        builder.append("\n\nProject detail\n");
        builder.append(etDetailProject.getText().toString());
        builder.append("\n\nProject category\n");
        builder.append(spCategories.getSelectedItem().toString());
        builder.append("\n\nProject type\n");
        builder.append(radioresult);
        builder.append("\n\nProject intent\n");
        builder.append(checkboxresult);

        tvResult.setText(builder);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCategories = (Spinner) findViewById(R.id.spinnerCategories);
        etNameProject = (EditText) findViewById(R.id.editTextName);
        etDetailProject = (EditText) findViewById(R.id.editTextDetail);
        tvResult = (TextView) findViewById(R.id.textViewResult);

        rbIn = (RadioButton) findViewById(R.id.radioButtonIn);
        rbGr = (RadioButton) findViewById(R.id.radioButtonGr);

        cbSA = (CheckBox) findViewById(R.id.checkBoxSA);
        cbSP = (CheckBox) findViewById(R.id.checkBoxSP);
        cbFP = (CheckBox) findViewById(R.id.checkBoxFP);

        findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {
                    doClick();
                }
            }
        });
    }
}
