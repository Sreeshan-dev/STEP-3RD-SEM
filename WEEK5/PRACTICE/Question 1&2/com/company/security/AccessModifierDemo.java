// package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    private void privateMethod() { System.out.println("Private method called"); }
    void defaultMethod() { System.out.println("Default method called"); }
    protected void protectedMethod() { System.out.println("Protected method called"); }
    public void publicMethod() { System.out.println("Public method called"); }

    public AccessModifierDemo(int p, String d, double pr, boolean pu) {
        privateField = p;
        defaultField = d;
        protectedField = pr;
        publicField = pu;
    }
}
