package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.activitylifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
         binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


//        Toast.makeText(MainActivity.this, "Oncreate() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onCreate() called");
        binding.button.setOnClickListener(v -> {
            //this is used to switch to the second activity we have created using intent class we can create our intent then pass it to proper
            //method avalible
            String value = binding.guessFeild.getText().toString().trim();//we can also add .trim() to remove the junk but i am not it now and just the actual val
if(!value.isEmpty()){
    Intent intent = new Intent(MainActivity.this, ShowGuess.class);
    intent.putExtra("guess", value);//we can put as many intents as we want
    intent.putExtra("aBoolean", true);
    intent.putExtra("age",19);
    intent.putExtra("nothing speacial","nothing special");
   //  startActivity(intent); the flaw in using only the start activity is that it does not expect anyresult so when we want to come back from an activity to main it will show error
    //as it was not expecting any result but coming back will have one so we have to use startActivityForResult() method which will take the result as well
    startActivityForResult(intent,REQUEST_CODE);
    //to hide keyboard
    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
}else {
    Toast.makeText(MainActivity.this,"please enter something in the given space", Toast.LENGTH_SHORT).show();
}

        });

    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(MainActivity.this, "onStart() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onStart() called");
//
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        Toast.makeText(MainActivity.this, "onPostResume() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onPostResume() called");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(MainActivity.this, "onPause() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onPause() called");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(MainActivity.this, "onStop() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onStop() called");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(MainActivity.this, "onDestroy() called", Toast.LENGTH_SHORT).show();
//        Log.d("Cycle","onDestroy() called");
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String message = data.getStringExtra("message_back");
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
        }
    }
}