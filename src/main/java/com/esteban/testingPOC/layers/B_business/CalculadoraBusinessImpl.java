package com.esteban.testingPOC.layers.B_business;

import com.esteban.testingPOC.layers.C_data.ICalculadoraData;

public class CalculadoraBusinessImpl {

    ICalculadoraData calculadoraData;

    // SETTER
    public void setCalculadoraData(ICalculadoraData ICalculadoraData) {
        this.calculadoraData = ICalculadoraData;
    }

    public int calculateSumUsandoDataLayer(){

        int[] data = calculadoraData.getDataDB();
        int result = 0;

        for(int value : data){
            result += value;
        }
        return result;
    }

    public int calculateSum(int[] data){

        int result = 0;

        for(int value : data){
            result += value;
        }
        return result;
    }


}
