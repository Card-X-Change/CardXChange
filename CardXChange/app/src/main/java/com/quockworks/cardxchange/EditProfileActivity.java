package com.quockworks.cardxchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    private Bundle bundle;
    private String profileType;

    private LinearLayout layEditProfile;
    private EditText firstName;
    private EditText lastName;
    private EditText company;
    private EditText role;
    private EditText phone;
    private EditText email;
    private EditText desiredSkills;
    private EditText personalSite;
    private EditText linkedinURL;
    private EditText skills;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bundle = getIntent().getExtras();
        profileType = bundle.getString("profileType");
        // Adjust number of fields based on profile type:
        layEditProfile = new LinearLayout(this);
        firstName = new EditText(this);
        lastName = new EditText(this);
        phone = new EditText(this);
        email = new EditText(this);
        submit = new Button(this);

        layEditProfile.setOrientation(LinearLayout.VERTICAL);

        firstName.setHint("First Name*");
        lastName.setHint("Last Name*");
        phone.setHint("Phone #*");
        email.setHint("Email Address*");
        submit.setText("Submit");

        firstName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lastName.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        phone.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        email.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        submit.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        firstName.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        lastName.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        phone.setInputType(InputType.TYPE_CLASS_PHONE);
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        // Recruiter
        if(profileType.equals("Recruiter")){
            company = new EditText(this);
            role = new EditText(this);
            desiredSkills = new EditText(this);
            company.setHint("Company*");
            role.setHint("Role*");
            desiredSkills.setHint("Most Desired Skills");
            company.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            role.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            desiredSkills.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            company.setInputType(InputType.TYPE_CLASS_TEXT);
            role.setInputType(InputType.TYPE_CLASS_TEXT);
            desiredSkills.setInputType(InputType.TYPE_CLASS_TEXT);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (firstName.getText().toString().length() > 0 &&
                            lastName.getText().toString().length() > 0 &&
                            company.getText().toString().length() > 0 &&
                            role.getText().toString().length() > 0 &&
                            phone.getText().toString().length() > 0 &&
                            email.getText().toString().length() > 0) {

                        /* Submit information to database here */

                        /**/
                        Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Missing data in required field!", Toast.LENGTH_LONG);
                    }
                }
            });

            layEditProfile.addView(firstName);
            layEditProfile.addView(lastName);
            layEditProfile.addView(company);
            layEditProfile.addView(role);
            layEditProfile.addView(desiredSkills);
            layEditProfile.addView(phone);
            layEditProfile.addView(email);
            layEditProfile.addView(submit);

            setContentView(layEditProfile);
        }

        // Candidate
        else if(profileType.equals("Candidate")){
            personalSite = new EditText(this);
            linkedinURL = new EditText(this);
            skills = new EditText(this);
            personalSite.setHint("Github or Personal Site");
            linkedinURL.setHint("LinkedIn URL");
            skills.setHint("Top Skills");
            personalSite.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linkedinURL.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            skills.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            personalSite.setInputType(InputType.TYPE_CLASS_TEXT);
            linkedinURL.setInputType(InputType.TYPE_CLASS_TEXT);
            skills.setInputType(InputType.TYPE_CLASS_TEXT);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (firstName.getText().toString().length() > 0 &&
                            lastName.getText().toString().length() > 0 &&
                            phone.getText().toString().length() > 0 &&
                            email.getText().toString().length() > 0) {

                        /* Submit information to database here */

                        /**/

                        Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Missing data in required field!", Toast.LENGTH_LONG);
                    }
                }
            });

            layEditProfile.addView(firstName);
            layEditProfile.addView(lastName);
            layEditProfile.addView(personalSite);
            layEditProfile.addView(linkedinURL);
            layEditProfile.addView(skills);
            layEditProfile.addView(phone);
            layEditProfile.addView(email);
            layEditProfile.addView(submit);

            setContentView(layEditProfile);
        }

        // Developer
        else{
            company = new EditText(this);
            role = new EditText(this);
            personalSite = new EditText(this);
            linkedinURL = new EditText(this);
            skills = new EditText(this);
            company.setHint("Company");
            role.setHint("Role");
            personalSite.setHint("Github or Personal Site");
            linkedinURL.setHint("LinkedIn URL");
            skills.setHint("Top Skills");
            company.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            role.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            personalSite.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linkedinURL.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            skills.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            company.setInputType(InputType.TYPE_CLASS_TEXT);
            role.setInputType(InputType.TYPE_CLASS_TEXT);
            personalSite.setInputType(InputType.TYPE_CLASS_TEXT);
            linkedinURL.setInputType(InputType.TYPE_CLASS_TEXT);
            skills.setInputType(InputType.TYPE_CLASS_TEXT);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (firstName.getText().toString().length() > 0 &&
                            lastName.getText().toString().length() > 0 &&
                            phone.getText().toString().length() > 0 &&
                            email.getText().toString().length() > 0) {

                        /* Submit information to database here */

                        /**/

                        Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Missing data in required field!",Toast.LENGTH_LONG);
                    }
                }
            });

            layEditProfile.addView(firstName);
            layEditProfile.addView(lastName);
            layEditProfile.addView(company);
            layEditProfile.addView(role);
            layEditProfile.addView(personalSite);
            layEditProfile.addView(linkedinURL);
            layEditProfile.addView(skills);
            layEditProfile.addView(phone);
            layEditProfile.addView(email);
            layEditProfile.addView(submit);

            setContentView(layEditProfile);
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



}
