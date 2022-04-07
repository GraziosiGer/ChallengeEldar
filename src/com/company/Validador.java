package com.company;

import com.company.Exceptions.FueraRangoTasaException;

public interface Validador {

    Boolean validar() throws FueraRangoTasaException;

}
