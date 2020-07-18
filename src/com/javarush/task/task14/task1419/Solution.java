package com.javarush.task.task14.task1419;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        try {
            throw new NullPointerException("id is null");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new SecurityException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new BufferUnderflowException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new FileNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new MalformedInputException(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try
        {
            throw new UnmappableCharacterException(1);
        } catch (Exception e) {
            exceptions.add(e);
        }
          try
        {
            throw new CharacterCodingException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
