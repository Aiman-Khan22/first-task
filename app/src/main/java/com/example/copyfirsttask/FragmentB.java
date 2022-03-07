package com.example.copyfirsttask;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView name,city;
    Button button;
    EditText editText,editText2;

    public FragmentB() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentB.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentB newInstance(String param1, String param2) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_b, container, false);

        name=view.findViewById(R.id.name);
        city=view.findViewById(R.id.city);
        name.setText(mParam1);
        city.setText(mParam2);


        editText=view.findViewById(R.id.editTextSchool);
        editText2=view.findViewById(R.id.editTextUniversity);
        button=view.findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String school=editText.getText().toString();
                String uni=editText2.getText().toString();
                String name=mParam1;
                String city=mParam2;
                Log.d("container"," FragmentB"+name+city);
                if(name.equals("")& city.equals("")){
                    Log.d("container"," null   "+name+city);
                }else{
                    FragmentC shopContainerFragment =  FragmentC.newInstance(name,city,school,uni);
                    requireActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, shopContainerFragment)
                            .addToBackStack(null)
                            .commit();
                }


            }
        });
        return view;

    }
}