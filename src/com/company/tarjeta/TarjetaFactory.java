package com.company.tarjeta;

import com.company.Titular;

import java.time.LocalDate;

public class TarjetaFactory {
    public static Tarjeta getTarjeta(String tipoTarjeta, int numero, Titular titular, LocalDate fechaVencimiento){
            if (tipoTarjeta.equalsIgnoreCase("Amex")) {
                return new Amex(numero, titular, fechaVencimiento);

            } else if (tipoTarjeta.equalsIgnoreCase("Nara")) {
                return new Nara(numero, titular, fechaVencimiento);

            } else if (tipoTarjeta.equalsIgnoreCase("Visa")) {
                return new Visa(numero, titular, fechaVencimiento);

            } else {
                throw new IllegalStateException("Tipo de tarjeta desconocida: " + tipoTarjeta);
            }
    }
}
