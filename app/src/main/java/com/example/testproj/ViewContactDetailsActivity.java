package com.example.testproj;

import android.content.Intent;
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

public class ViewContactDetailsActivity extends AppCompatActivity {

    private EditText etName, etContactPerson, etContact, etEmail, etD1, etD2, etD3, etSecretary, etS1, etS2, etS3, etFinancialYED;
    private Button btnUpdate, btnDelete;
    private int contactId;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact_details);

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
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        client = new AsyncHttpClient();

        Intent intent = getIntent();
        contactId = intent.getIntExtra("client_id", -1);

        //TODO: call getContactDetails.php with the id as a parameter
        //TODO: set the text fields with the data retrieved

        RequestParams params = new RequestParams();
        params.add("id", String.valueOf(contactId));

        //View Contact Details
        //Using GET


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("client_id", String.valueOf(contactId));
                params.put("name", etName.getText().toString());
                params.put("contactPerson", etContactPerson.getText().toString());
                params.put("contact", etContact.getText().toString());
                params.put("email", etEmail.getText().toString());
                params.put("director1", etD1.getText().toString());
                params.put("director2", etD2.getText().toString());
                params.put("director3", etD3.getText().toString());
                params.put("secretary", etSecretary.getText().toString());
                params.put("shareholder1", etS1.getText().toString());
                params.put("shareholder2", etS2.getText().toString());
                params.put("shareholder3", etS3.getText().toString());
                params.put("financialYED", etFinancialYED.getText().toString());


                client.get("http://smac-biz.000webhostapp.com/SmacBiz/updateClient.php", params, new JsonHttpResponseHandler() {
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
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params = new RequestParams();
                params.put("client_id", String.valueOf(contactId));

                client.get("http://smac-biz.000webhostapp.com/SmacBiz/deleteClient.php", params, new JsonHttpResponseHandler() {
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
        });
    }
}



