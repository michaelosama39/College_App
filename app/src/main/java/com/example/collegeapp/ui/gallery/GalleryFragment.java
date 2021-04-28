package com.example.collegeapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView convoRecycler , othersRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecycler = view.findViewById(R.id.convoRecycler);
        othersRecycler = view.findViewById(R.id.othersRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getconvoImage();
        getothersImage();

        return view;
    }

    private void getothersImage(){
        reference.child("Others Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext() , imageList);
                othersRecycler.setLayoutManager(new GridLayoutManager(getContext() , 3 ));
                othersRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getconvoImage(){
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext() , imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext() , 3 ));
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}