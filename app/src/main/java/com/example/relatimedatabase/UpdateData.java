package com.example.relatimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.relatimedatabase.databinding.ActivityUpdateDataBinding;
//import com.example.relatimedatabase.databinding.
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UpdateData extends AppCompatActivity {

    ActivityUpdateDataBinding binding;
    DatabaseReference databaseReference;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_update_data);


        delete =findViewById(R.id.deleteBtn);
//        logout =findViewById(R)

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =new Intent(UpdateData.this, DeleteData.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userName = binding.userName.getText().toString();
                String dateOfBirth = binding.dateofbirth.getText().toString();
                String email = binding.email.getText().toString();
                String gender = binding.gender.getText().toString();
                String occupation = binding.occupation.getText().toString();
                String userNumber = binding.userPhone.getText().toString();
//                String lastName = binding.lastname.getText().toString();
//                String age = binding.age.getText().toString();


                updateData(userName, dateOfBirth, email, gender, occupation, userNumber);

            }
        });



    }

    private void updateData(String dateOfBirth,String email,String gender,String occupation,String userName,String userNumber) {

        HashMap User = new HashMap();
        User.put(("userNumber"),userNumber);
        User.put(("userName"),userName);
        User.put("dateOfBirth",dateOfBirth);
        User.put("email",email);
        User.put("gender",gender);
        User.put("occupation",occupation);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference.child(userNumber).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {

                if (task.isSuccessful()){

                    binding.userName.setText("");
//                    binding.userPhone
                    binding.userPhone.setText("");
                    binding.dateofbirth.setText("");
                    binding.email.setText("");
                    binding.gender.setText("");
                    binding.occupation.setText("");


                    Toast.makeText(UpdateData.this,"Successfuly Updated",Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(UpdateData.this,"Failed to Update",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}