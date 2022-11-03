package com.example.relatimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.relatimedatabase.databinding.ActivityUpdateDataBinding;
//import com.example.relatimedatabase.databinding.
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateData extends AppCompatActivity {

    ActivityUpdateDataBinding binding;
    DatabaseReference databaseReference;
    private Button delete;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_update_data);


//        delete =findViewById(R.id.deleteBtn);
//        logout =findViewById(R)


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
        });
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(UpdateData.this, DeleteData.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//                finish();
//            }
//        });



    }
//
//    private void addListenerOnSpinnerItemSelection() {
//
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//    }
//
//    private void addListenerOnButton() {
//        void addListenerOnButton() {
//
////            spinner1 = (Spinner) findViewById(R.id.spinner1);
//            spinner2 = (Spinner) findViewById(R.id.spinner2);
////            btnSubmit = (Button) findViewById(R.id.btnSubmit);
//
////            btnSubmit.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//
//                    Toast.makeText(MyAndroidAppActivity.this,
//                            "OnClickListener : " +
//                                    "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
//                                    "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
//                            Toast.LENGTH_SHORT).show();
//                }
//
//            });
//        }
//
//    }
//
//    private void addItemsOnSpinner2() {
//
//        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        List<String> list = new ArrayList<String>();
//        list.add("Male");
//        list.add("Female");
//        list.add("Other");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner2.setAdapter(dataAdapter);
//    }

    private void updateData(String dateOfBirth,String email,String gender,String occupation,String userName,String userNumber) {

        HashMap User = new HashMap();
        User.put(("userNumber"),userNumber);
        User.put(("userName"),userName);
        User.put("Dateofbirth",dateOfBirth);
        User.put("Email",email);
        User.put("Gender",gender);
        User.put("Occupation",occupation);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(userNumber).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful()){
                    if(userName.isEmpty()){
                        binding.userName.setError("Enter valid username");
                    }else if(userName.length()<3){
                        binding.userName.setError("Enter vailed username");
                    }else{
                        Toast.makeText(UpdateData.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        binding.userName.setText("");
                    }


//                    binding.userPhone
                    binding.userPhone.setText("");
                    binding.dateofbirth.setText("");
                    binding.email.setText("");
                    binding.gender.setText("");
                    binding.occupation.setText("");


                    Toast.makeText(UpdateData.this,"Successfully Updated",Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(UpdateData.this,"Failed to Update",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}