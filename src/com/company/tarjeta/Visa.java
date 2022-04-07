package com.company.tarjeta;

import com.company.Titular;

import java.time.LocalDate;

public class Visa extends Tarjeta{
    public Visa(int numero, Titular titular, LocalDate fechaVencimiento) {

        super(numero,titular,fechaVencimiento);
    }

    @Override
    public double getTasaActual(){
        LocalDate fechaActual = LocalDate.now();
        double ultimosDosDigitosAnio = fechaActual.getYear()%100;
        double tasa = ultimosDosDigitosAnio / fechaActual.getDayOfMonth();
        return tasa;
    }
}
