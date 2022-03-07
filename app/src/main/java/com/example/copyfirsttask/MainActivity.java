package com.example.copyfirsttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
   FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        FragmentA shopContainerFragment =  FragmentA.newInstance("cc","ff");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, shopContainerFragment)
                .commit();
    }
    public void onBackPressed() {
        super.onBackPressed();
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.container);
        Log.d("fragmentsCount", " id !" + f);
        if(f instanceof FragmentC){
            fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            FragmentA shopContainerFragment =  FragmentA.newInstance("cc","ff");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, shopContainerFragment)
                    .commit();
        }
        else{
            int fragments = getSupportFragmentManager().getBackStackEntryCount();
            if (fragments > 0) {

                getSupportFragmentManager().popBackStack();
            }else{
                finishAffinity();
            }

        }
    }
}