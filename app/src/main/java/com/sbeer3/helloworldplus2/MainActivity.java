package com.sbeer3.helloworldplus2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.text.Editable;

//Initialized the main activity
public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {
    //sets up the fragment manager and transactions
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    //this occurs when the app is opened, it adds the fragment to the view and then makes it work
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            MainFragment helloFrag = new MainFragment();
            fragmentTransaction.add(R.id.container, helloFrag);
            fragmentTransaction.commit();
        }




    }

    //this implements the interaction class from the fragment, so that when the fragment is used, it pushes data here to also be logged.
    public void onFragmentInteraction(Editable name) {
        String TAG = "Activity";
        Log.v(TAG, "Name Entered: " + name);
    }
}