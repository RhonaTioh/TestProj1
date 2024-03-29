package com.example.testproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {


    private ListView lvContact;
    private ArrayList<Contact> alContact;
    private ArrayAdapter<Contact> aaContact;
    private AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = (ListView) findViewById(R.id.listViewContact);
        client = new AsyncHttpClient();

        alContact = new ArrayList<Contact>();

        aaContact = new ContactAdapter(getApplicationContext(), R.layout.contact_row, alContact);
        lvContact.setAdapter(aaContact);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contact selectedContact = alContact.get(position);
                Intent i = new Intent(getBaseContext(), ViewContactDetailsActivity.class);
                i.putExtra("client_id", selectedContact.getId());
                startActivity(i);
            }
        });

        client.get("http://smac-biz.000webhostapp.com/SmacBiz/getClient.php", new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    Log.i("JSON Results: ", response.toString());
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObj = response.getJSONObject(i);

                        int Id = jsonObj.getInt("client_id");
                        String Name = jsonObj.getString("name");
                        String ContactPerson = jsonObj.getString("contactPerson");
                        String Contact = jsonObj.getString("contact");
                        String Email = jsonObj.getString("email");
                        String D1 = jsonObj.getString("director1");
                        String D2 = jsonObj.getString("director2");
                        String D3 = jsonObj.getString("director3");
                        String secretary = jsonObj.getString("secretary");
                        String S1 = jsonObj.getString("shareholder1");
                        String S2 = jsonObj.getString("shareholder2");
                        String S3 = jsonObj.getString("shareholder3");
                        String financialYED = jsonObj.getString("financialYearEndDate");

                        Contact contact = new Contact(Id, Name, ContactPerson, Contact, Email, D1, D2, D3, secretary, S1, S2, S3, financialYED);
                        alContact.add(contact);
                    }
                    aaContact.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });

    }

    //refresh with latest contact data whenever this activity resumes
    @Override
    protected void onResume() {
        super.onResume();



    }//end onResume


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intent = new Intent(MainActivity.this, CreatContactActivity.class);
                startActivity(intent);
        }
        return true;
    }
}