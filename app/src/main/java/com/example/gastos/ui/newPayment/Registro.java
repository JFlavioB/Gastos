package com.example.gastos.ui.newPayment;

import java.util.Date;

public class Registro {
    int idRegistro;
    String concepto;
    Double cantidad;
    String comentarios;
    String fecha;

    int idUsuario;


    public Registro() {
    }

    public Registro(int idRegistro, String concepto, Double cantidad, String comentarios, String fecha, int idUsuario) {
        this.idRegistro = idRegistro;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.comentarios = comentarios;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String toString() {
        return concepto;
    }
/*
    @Override
    public String toString() {
        return "Registro{" +
                "idRegistro=" + idRegistro +
                ", concepto='" + concepto + '\'' +
                ", cantidad=" + cantidad +
                ", comentarios='" + comentarios + '\'' +
                ", fecha='" + fecha + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }

    */
}
