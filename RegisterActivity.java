package com.example.aisling.finalprojectaislingstafford;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText firstNameView;
    private EditText lastNameView;
    private EditText profileImageUrl;
    String enteredEmail;
    String enteredPassword;
    String enteredFirstName;
    String enteredLastName;
    String enteredImageURl;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        firstNameView = (EditText) findViewById(R.id.first_name);
        lastNameView = (EditText) findViewById(R.id.last_name);
        profileImageUrl = (EditText) findViewById(R.id.profileImageUrl);


        submitButton = (Button) findViewById(R.id.register_button);

        //Setting listeners to button
        submitButton.setOnClickListener(this);

        //submitButton.setOnClickListener(new View.OnClickListener()
        // {
        //     @Override
        //     public void onClick(View v)
        //     {
        //         if(v == submitButton)
        //         {
        //             addUser();
        //         }

        //    }

        // });
    }

    private void addUser() {
        enteredEmail = mEmailView.getText().toString();
        enteredPassword = mPasswordView.getText().toString();
        enteredFirstName = firstNameView.getText().toString();
        enteredLastName = lastNameView.getText().toString();
        enteredImageURl = profileImageUrl.getText().toString();

        if (enteredEmail.equals("") || enteredPassword.equals("") || enteredFirstName.equals("") || enteredLastName.equals("") || enteredImageURl.equals("")) {

            Toast.makeText(RegisterActivity.this, "Username or password or email must be filled", Toast.LENGTH_LONG).show();

            return;

        }

        if (enteredEmail.length() <= 1 || enteredPassword.length() <= 1) {

            Toast.makeText(RegisterActivity.this, "Email or password length must be greater than one", Toast.LENGTH_LONG).show();

            return;

        }

        class AddUser extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Adding...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_FIRST_NAME, enteredFirstName);
                params.put(Config.KEY_LAST_NAME, enteredLastName);
                params.put(Config.KEY_EMAIL, enteredEmail);
                params.put(Config.KEY_PASSWORD, enteredPassword);
                params.put(Config.KEY_PROFILE_IMAGE_URL, enteredImageURl);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }



        AddUser au = new AddUser();
        au.execute();
    }

    @Override
    public void onClick(View v)
    {

        if (v == submitButton)
        {
            addUser();
            startActivity(new Intent(this, MainActivity.class));
        }


    }

}