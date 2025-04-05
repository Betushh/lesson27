package com.mydemo.mydemo.serviceImp;

import com.mydemo.mydemo.Services.serviceImp.CalculatorServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceImplTest {

    @Mock
    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @AfterEach
    void tearDown() {
        calculatorService = null;
    }

    @Test
    public void givenPositiveAAndPositiveBThenSum() {
        double result = calculatorService.sum(2, 2);

        assertThat(result).isEqualTo(4);
        assertThat(result).isBetween(1.0, 9.4);

    }


    @Test
    public void givenNegativeAAndPositiveBThenSum() {
        double result = calculatorService.sum(-2, 2);

        assertThat(result).isEqualTo(0);
        assertThat(result).isGreaterThan(-3.0);

    }

    @Test
    public void givenNegativeAAndNegativeBThenSum() {
        double result = calculatorService.sum(-2, 2);

        assertThat(result).isEqualTo(0);

    }

    @Test
    public void givenAAndNotZeroBThenDivide(){
    double result = calculatorService.divide( 15, 5);

    assertThat(result).isEqualTo(3);
}

@Test
    public void givenAAndNotZeroBThenDivideThenException(){
        assertThatThrownBy(()->calculatorService.divide(15,0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("no no no");
}


}