package com.sbeer3.helloworldplus2;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import android.util.Log;

//This is the class creation for the "MainFragment" which is an extension of the Fragment class
public class MainFragment extends Fragment {
    EditText helloUser;
    Button helloBtn;
    OnFragmentInteractionListener listener;
    String TAG = "Fragment";

    public MainFragment() {
        // Required empty public constructor
    }

    //This is everything that happens on fragment creation
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_main, container, false);

        //initializing the button and edittext
        helloUser = myView.findViewById(R.id.Hello_World_Input);
        helloBtn = myView.findViewById(R.id.Hello_World_Button);
        //This listens for a button interaction, and when interacted with, returns the inputted string to 3 places, it logs it, it sends it to the activity to log it, and it toasts it
        helloBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Editable user = helloUser.getText();
                Toast.makeText(getActivity(), "Hello " + user, Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Name Entered: " + user);
                listener.onFragmentInteraction(user);
            }
        });



        return myView;
    }

    //everything that occurs when the fragment is attached to the main activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //this is how you send data to the main activity from the fragment
        try {
            listener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement on click listener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    //This is how you can now implement the listener in the main activity, where the name info will be taken in
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Editable name);
    }

}