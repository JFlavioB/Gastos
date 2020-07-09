package com.example.gastos.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastos.R;
import com.example.gastos.ui.newPayment.Registro;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Registro> listRegistro = new ArrayList<>();
    ArrayAdapter<Registro> arrayAdapterRegistro;

    private HomeViewModel homeViewModel;
    private ListView listRegistros;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Registro registroSeleccionado;

    RecyclerView recyclerViewRegistros;
    Registro rAdapter;
   // FirebaseFirestore firebaseFirestore;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

      listRegistros = root.findViewById(R.id.lv_datosRegistro);



        inicializarFirebase();
        listarDatos();

        final TextView textView = root.findViewById(R.id.text_home);

        homeViewModel.getText().observe(getViewLifecycleOwner(),
                new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });


        return root;
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference();
    }

    private void listarDatos() {
        databaseReference.child("Registro").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listRegistro.clear();
                for (DataSnapshot obSnapshot : dataSnapshot.getChildren()) {
                    Registro r = obSnapshot.getValue(Registro.class);
                    listRegistro.add(r);
                    arrayAdapterRegistro = new ArrayAdapter<Registro>(getContext(), android.R.layout.simple_list_item_1, listRegistro);
                    listRegistros.setAdapter(arrayAdapterRegistro);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}