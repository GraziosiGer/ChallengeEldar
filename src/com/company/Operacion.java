package com.company;

import com.company.Exceptions.FueraRangoTasaException;
import com.company.Exceptions.MontoExcesivoException;
import com.company.Exceptions.MontoNegativoException;
import com.company.Exceptions.TarjetaVencidaException;
import com.company.tarjeta.Tarjeta;

import java.util.Scanner;

public class Operacion implements Validador {
    private final Tarjeta tarjetaUtilizada;
    private int montoParcial;
    private final int montoMaximo = 1000;
    private double tasa;
    private double montoTotal;

    public Operacion( Tarjeta tarjetaUtilizada, int montoParcial) {
        this.tarjetaUtilizada = tarjetaUtilizada;
        this.montoParcial = montoParcial;
        if (montoParcial < 0) {
            do {
                try {
                    throw new MontoNegativoException("El monto de la operacion es negativo, por favor vuelva a ingresar el monto: ");

                } catch (MontoNegativoException e) {
                    e.printStackTrace();
                    Scanner reader = new Scanner(System.in);
                    this.montoParcial = reader.nextInt();
                }
            } while (this.montoParcial < 0);
        }
    }

    @Override
    public Boolean validar() {
        this.tasa = this.tarjetaUtilizada.getTasaActual();
        this.montoTotal = montoParcial * tasa;
        try {

            if (tasa < 0.3 || tasa > 5) {
                throw new FueraRangoTasaException("La tasa ("+tasa+") quedo fuera del rango permitido, operacion cancelada");
            }
            else if (montoTotal > this.montoMaximo){
                throw new MontoExcesivoException("El monto total $"+montoTotal+" excede el maximo permitido ($"+this.montoMaximo+")");
            }
            else if (!this.tarjetaUtilizada.validar()){
                return false;
            }
        }
        catch(FueraRangoTasaException | MontoExcesivoException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public String getTasaImporteMarca(){
        return "Marca: " + this.tarjetaUtilizada.getClass().getSimpleName() +"\n"
                +"Importe: "+ this.montoTotal +"\n"
                +"Tasa: "+this.tasa;
    }
}
