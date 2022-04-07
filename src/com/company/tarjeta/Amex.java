package com.company.tarjeta;

import com.company.Titular;

import java.time.LocalDate;

public class Amex extends Tarjeta {
    public Amex(int numero, Titular titular, LocalDate fechaVencimiento) {
        super(numero, titular,fechaVencimiento);
    }

    @Override
    public double getTasaActual(){
        LocalDate fechaActual = LocalDate.now();
        double tasa = fechaActual.getMonthValue() * 0.1 ;
        return tasa;
    }
}
