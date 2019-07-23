package com.example.testproj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class CreatContactActivity extends AppCompatActivity {

    private EditText etName, etContactPerson, etContact, etEmail, etD1, etD2, etD3, etSecretary, etS1, etS2, etS3, etFinancialYED;
    private Button btnCreate;
    private AsyncHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        etName = findViewById(R.id.etName);
        etContactPerson = findViewById(R.id.etContactPerson);
        etContact = findViewById(R.id.etContactNumber);
        etEmail = findViewById(R.id.etEmail);
        etD1 = findViewById(R.id.etDirector1);
        etD2 = findViewById(R.id.etDirector2);
        etD3 = findViewById(R.id.etDirector3);
        etSecretary = findViewById(R.id.etSecretary);
        etS1 = findViewById(R.id.etShareHolder1);
        etS2 = findViewById(R.id.etShareHolder2);
        etS3 = findViewById(R.id.etShareHolder3);
        etFinancialYED = findViewById(R.id.etFinancialYED);
        btnCreate = findViewById(R.id.btnCreate);
        client = new AsyncHttpClient();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCreateOnClick(v);
            }
        });

    }//end onCreate


    //add
    private void btnCreateOnClick(View v) {
        RequestParams params = new RequestParams();
        params.add("name", etName.getText().toString());
        params.add("contactPerson",etContactPerson.getText().toString());
        params.add("contact", etContact.getText().toString());
        params.add("email", etEmail.getText().toString());
        params.add("director1", etD1.getText().toString());
        params.add("director2", etD2.getText().toString());
        params.add("director3", etD3.getText().toString());
        params.add("secretary",etSecretary.getText().toString());
        params.add("shareholder1", etS1.getText().toString());
        params.add("shareholder2", etS2.getText().toString());
        params.add("shareholder3", etS3.getText().toString());
        params.add("financialYearEndDate", etFinancialYED.getText().toString());

        client.get("http://smac-biz.000webhostapp.com/SmacBiz/insertClient.php", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Log.i("JSON Results: ", response.toString());

                    Toast.makeText(getApplicationContext(), response.getString("message"), Toast.LENGTH_SHORT).show();

                    finish();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}