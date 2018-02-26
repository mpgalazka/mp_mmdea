package com.example;


public class Main
{
    public static void main(final String[] args)
    {

        final Config c = new Config();

        final MyClass exportRecords = new MyClass(c);
        exportRecords.doPost();

    }
}
