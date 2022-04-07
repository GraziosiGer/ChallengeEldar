package com.company.tarjeta;

import com.company.Titular;

import java.time.LocalDate;

public class Nara extends Tarjeta{
    public Nara(int numero, Titular titular, LocalDate fechaVencimiento) {
        super(numero, titular, fechaVencimiento);
    }

    @Override
    public double getTasaActual(){
        LocalDate fechaActual = LocalDate.now();
        double tasa = fechaActual.getDayOfMonth() * 0.5;
        return tasa;
    }
}
