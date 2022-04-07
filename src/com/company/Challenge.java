package com.company;

import com.company.Exceptions.FueraRangoTasaException;
import com.company.tarjeta.Tarjeta;
import com.company.tarjeta.Visa;

import java.time.LocalDate;

public class Challenge {

    public static void main(String[] args) throws FueraRangoTasaException {

        Tarjeta tarjeta = new Visa(123456,new Titular("German", "Graziosi"), LocalDate.of(2022,4,20));
        Operacion operacion = new Operacion(tarjeta,-500);

        System.out.println(tarjeta.getInformacionTarjeta());

        System.out.println("La operacion es valida?: " + operacion.validar());

        System.out.println("La tarjeta es valida?: " + tarjeta.validar());

        Tarjeta tarjetaB = new Visa(123456,new Titular("Juan", "Perez"), LocalDate.of(2022,4,20));

        System.out.println(tarjetaB.getInformacionTarjeta());

        System.out.println("Las tarjetas son iguales?: " + tarjeta.equals(tarjetaB));

        System.out.println(operacion.getTasaImporteMarca());

    }
}
