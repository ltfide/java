package dev.local;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dev.local.data.Data;

public class TypeVariableTest {

    @Test
    void testGetTypeVariables() {

        Class<Data> dataClass = Data.class;

        TypeVariable<Class<Data>>[] typeVariables = dataClass.getTypeParameters();

        for (TypeVariable<Class<Data>> variable : typeVariables) {
            System.out.println(variable.getName()); // T
            System.out.println(Arrays.toString(variable.getBounds()));
            // [interface java.lang.AutoCloseable, interface java.io.Serializable]
            System.out.println(variable.getGenericDeclaration());
            // class dev.local.data.Data
        }

    }
}
