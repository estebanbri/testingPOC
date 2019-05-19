package com.esteban.testingPOC.mockito.Layers_Testing;

import com.esteban.testingPOC.layers.B_business.CalculadoraBusinessImpl;
import com.esteban.testingPOC.layers.C_data.ICalculadoraData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusinessLayerTestV2 {

    @InjectMocks
    CalculadoraBusinessImpl calculadoraBusiness;

    @Mock
    ICalculadoraData calculadoraData;

    @Test
    public void m1(){
        when(calculadoraData.getDataDB()).thenReturn(new int[] {1,2,3});

        assertThat(calculadoraBusiness.calculateSumUsandoDataLayer(), is(6));
    }

//    @Test
//    public void m2(){
//        when(calculadoraData.getDataDB()).thenReturn(new int[] {1,2,3});
//
//        verify(calculadoraBusiness).callAOtroMetodo(anyInt());
//    }
}

//                +---------------+       +------------+
//  Testeando ->  | @InjectMocks  |   <-  | @Mock      |
//                |---------------|       |------------|
//                | Business Layer|       | Data Layer |
//                +---------------+       +------------+
