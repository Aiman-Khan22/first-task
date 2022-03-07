package com.example.copyfirsttask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentC extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM4 ="param3" ;
    private static final String ARG_PARAM3 ="param4" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    TextView name,city,school,uni;
    Button btnC;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    public FragmentC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentC.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentC newInstance(String param1, String param2,String mParam3,String mParam4) {
        FragmentC fragment = new FragmentC();
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
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_c, container, false);
        fragmentManager = requireActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        name=view.findViewById(R.id.nameC);
        city=view.findViewById(R.id.cityC);
        school=view.findViewById(R.id.schoolC);
        uni=view.findViewById(R.id.universityC);
        btnC=view.findViewById(R.id.btn3);

        Log.d("container"," FragmentC   "+mParam1+mParam2+mParam3+mParam4);
        name.setText(mParam1);
        city.setText(mParam2);
        school.setText(mParam3);
        uni.setText(mParam4);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // clear the backstack to move on main Shopping screen
//                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                FragmentA shopContainerFragment =  FragmentA.newInstance("cc","ff");
//                requireActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .add(R.id.container, shopContainerFragment)
//                        .commit();
                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                /*Navigate to the main shopping screen to continue shopping*/
                Fragment shopFragment = FragmentA.newInstance("cc","ff");
                transaction.replace(R.id.container, shopFragment);
                transaction.commit();
            }
        });
        return  view;
    }
}