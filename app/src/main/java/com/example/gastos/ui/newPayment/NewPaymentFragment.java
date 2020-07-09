package com.example.gastos.ui.newPayment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gastos.MainActivity;
import com.example.gastos.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class NewPaymentFragment extends Fragment {

    private NewPaymentViewModel newPaymentViewModel;



    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    EditText txtConcepto, txtCantidad, txtComentarios;
    Button btnRegistrar, btnFecha;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        newPaymentViewModel = ViewModelProviders.of(this).get(NewPaymentViewModel.class);

        View root = inflater.inflate(R.layout.fragment_newpayment, container, false);

        txtConcepto = (EditText) root.findViewById(R.id.txt_concepto);
        txtCantidad = (EditText) root.findViewById(R.id.txt_cantidad);
        txtComentarios = (EditText) root.findViewById(R.id.txt_comentarios);

        btnFecha = (Button) root.findViewById(R.id.btn_fecha);
        btnRegistrar = (Button) root.findViewById(R.id.btn_registrar);


        final Date date = new Date();
        final DateFormat format = new   SimpleDateFormat("dd-MM-yyyy");

        btnFecha.setText(format.format(date));
        // registros = FirebaseDatabase.getInstance().getReference("Registro");

        IniciarFirebase();



        //
        // final Date fechaR = (Date) btnFecha.getText();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double cantidad = 0.0;
                String concepto = txtConcepto.getText().toString();
                String comentarios = txtComentarios.getText().toString();
                String strFecha = btnFecha.getText().toString();

                String strCantidad = txtCantidad.getText().toString();
                if (concepto.equals("") || cantidad.equals("")) {
                    txtConcepto.setError("Required");
                    txtCantidad.setError("Required");
                } else if (strCantidad.equals("")) {
                    Toast.makeText(getContext(), "La cantidad debe ser mayor a cero", Toast.LENGTH_SHORT).show();

                } else {
                    cantidad = Double.parseDouble(txtCantidad.getText().toString());

                    Registro r = new Registro();
                    r.setIdRegistro(5);
                    r.setConcepto(concepto);
                    r.setCantidad(cantidad);
                    r.setComentarios(comentarios);
                    r.setFecha(strFecha);
                    r.setIdUsuario(1);

                    databaseReference.child("Registro").child(r.getConcepto()).setValue(r);
                    Toast.makeText(getContext(), "Registrando... ", Toast.LENGTH_SHORT).show();
                    borrarCampos();


                    Intent intentMain = new Intent(getContext(), MainActivity.class);
                    startActivity(intentMain);
                }

            }
        });

        return root;
    }

    private void IniciarFirebase() {
        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();

    }

    private void borrarCampos() {
        txtConcepto.setText("");
        txtCantidad.setText("");
        txtComentarios.setText("");
    }


}