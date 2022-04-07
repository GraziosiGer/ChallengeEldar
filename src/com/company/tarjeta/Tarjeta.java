package com.company.tarjeta;

import com.company.Exceptions.FueraRangoTasaException;
import com.company.Exceptions.TarjetaVencidaException;
import com.company.Titular;
import com.company.Validador;

import java.time.*;


public abstract class Tarjeta implements Validador {
    private final int numero;
    private Titular titular;
    private LocalDate fechaVencimiento;

    public Tarjeta(int numero, Titular titular, LocalDate fechaVencimiento) {
        this.numero = numero;
        this.titular = titular;
        this.fechaVencimiento = fechaVencimiento;
    }

    public abstract double getTasaActual();

    @Override
    public Boolean validar() {
        LocalDate fechaActual = LocalDate.now();
        try {
            if (this.fechaVencimiento.isBefore(fechaActual)) {
                throw new TarjetaVencidaException("Al dia de hoy : " + fechaActual + ", la fecha de vencimiento de su tarjeta es : " +
                        this.fechaVencimiento + ", por lo tanto su tarjeta de credito se encuentra vencida.");
            }
        } catch (TarjetaVencidaException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean equals(Tarjeta otraTarjeta) {
        return this.numero == otraTarjeta.getNumero();
    }

    private int getNumero() {
        return this.numero;
    }

    public String getInformacionTarjeta(){
        return("Titular : " + this.titular.getNombreCompleto() +"\n"
                +"Marca : " + this.getClass().getSimpleName() + "\n"
                +"Numero de tarjeta : " + this.numero + "\n"
                +"Fecha de vencimiento : " + this.fechaVencimiento.toString());
    }
}
