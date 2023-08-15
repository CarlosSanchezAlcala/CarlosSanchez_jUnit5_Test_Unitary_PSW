/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

    static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Antes de cada método");
    }

    @Disabled("Se deshabilitó por problemas con la clase principal")
    @Test
    @DisplayName("1.5 + 1.5 = 3.0")
    void addsTwoNumbers() {
        //Calculator calculator = new Calculator();
        assertEquals(3.0, calculator.add(1.5, 1.5), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        //Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    void isTrue() {
        assertTrue(calculator.isTrue());
    }

    @AfterEach
    void afterEach() {
        System.out.println("Después de cada método");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Después de todos los métodos de la clase");
    }
}
