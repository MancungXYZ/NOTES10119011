package com.example.uas_akb_if1_10119011;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
//Identitas
//Nama  : Reihan Wiyanda
//Kelas : IF-1
//Nim   : 10119011
public class Keluar extends Fragment {
    FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signOut();

        View view = inflater.inflate(R.layout.activity_login, container, false);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity(), LoginAct.class);
        startActivity(intent);
    }
}