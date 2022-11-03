package com.example.relatimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.relatimedatabase.databinding.ActivityUpdateDataBinding;
//import com.example.relatimedatabase.databinding.
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class UpdateData extends AppCompatActivity {

    ActivityUpdateDataBinding binding;
    DatabaseReference databaseReference;
    private Button delete;
    private Spinner spinner2;
    private EditText dateofbirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_update_data);

//        delete =findViewById(R.id.deleteBtn);
//        dateofbirth.findViewById(R.id.dateofbirth);
//        logout =findViewById(R)
        dateofbirth= binding.dateofbirth.findViewById(R.id.dateofbirth);
        binding.dateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                int year =c.get(Calendar.YEAR);
                int month= c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        UpdateData.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                dateofbirth.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();



            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner = (Spinner)findViewById(R.id.spinner2);
                String gender = spinner.getSelectedItem().toString();
                String userName = binding.userName.getText().toString();
                String dateOfBirth = binding.dateofbirth.getText().toString();
                String email = binding.email.getText().toString();
//                String gender = binding.gender.getText().toString();
                String occupation = binding.occupation.getText().toString();
                String userNumber = binding.userPhone.getText().toString();
//                String lastName = binding.lastname.getText().toString();
//                String age = binding.age.getText().toString();

                updateData(userName, dateOfBirth, email, gender, occupation, userNumber);


    }

    private void updateData(String dateOfBirth,String email,String gender,String occupation,String userName,String userNumber) {

        HashMap User = new HashMap();
        User.put(("userNumber"), userNumber);
        User.put(("userName"), userName);
        User.put("Dateofbirth", dateOfBirth);
        User.put("Email", email);
        User.put("Gender", gender);
        User.put("Occupation", occupation);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(userNumber).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful()) {
                    if (userName.isEmpty()) {
                        binding.userName.setError("Enter valid username");
                    } else if (userName.length() < 3) {
                        binding.userName.setError(" username too short");
                    } else {
                        Toast.makeText(UpdateData.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        binding.userName.setText("");
                    }


//                    binding.userPhone
                    binding.userPhone.setText("");
                    binding.dateofbirth.setText("");
                    binding.email.setText("");
                    binding.gender.setText("");
                    binding.occupation.setText("");


                    Toast.makeText(UpdateData.this, "Successfully Updated", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(UpdateData.this, "Failed to Update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }});}}