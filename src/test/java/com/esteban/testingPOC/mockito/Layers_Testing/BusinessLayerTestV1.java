package com.esteban.testingPOC.mockito.Layers_Testing;

import com.esteban.testingPOC.layers.B_business.CalculadoraBusinessImpl;
import com.esteban.testingPOC.layers.C_data.ICalculadoraData;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BusinessLayerTestV1 {

    CalculadoraBusinessImpl calculadoraBusiness = new CalculadoraBusinessImpl();

    ICalculadoraData calculadoraData = mock(ICalculadoraData.class);

    @Before
    public void init(){
        calculadoraBusiness.setCalculadoraData(calculadoraData);
    }

    @Test
    public void m1(){
        when(calculadoraData.getDataDB()).thenReturn(new int[] {1,2,3});

        assertThat(calculadoraBusiness.calculateSumUsandoDataLayer(), is(6));
    }
}
//                +---------------+       +------------+
//  Testeando ->  |  setter       |   <-  | mock()     |
//                |---------------|       |------------|
//                | Business Layer|       | Data Layer |
//                +---------------+       +------------+
