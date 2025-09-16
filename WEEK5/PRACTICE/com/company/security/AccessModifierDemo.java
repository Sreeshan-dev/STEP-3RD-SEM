package WEEK5.PRACTICE.com.company.security;

//package com.company.security;

public class AccessModifierDemo {

    // fields with different access modifiers
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    // constructor
    public AccessModifierDemo(int p, String d, double pr, boolean pub) {
        privateField   = p;
        defaultField   = d;
        protectedField = pr;
        publicField    = pub;
    }

    // methods with matching access levels
    private void privateMethod()    { System.out.println("Private method called"); }
    void defaultMethod()            { System.out.println("Default method called"); }
    protected void protectedMethod(){ System.out.println("Protected method called"); }
    public void publicMethod()      { System.out.println("Public method called"); }

    // shows internal access to every member
    public void testInternalAccess() {
        System.out.println("--- Inside testInternalAccess ---");
        System.out.println("privateField   = " + privateField);
        System.out.println("defaultField   = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField    = " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(42, "hello", 3.14, true);

        // Public: always fine
        System.out.println(obj.publicField);
        obj.publicMethod();

        // Default & protected: fine inside same package
        System.out.println(obj.defaultField);
        obj.defaultMethod();
        System.out.println(obj.protectedField);
        obj.protectedMethod();

        // Private: not allowed here
        // System.out.println(obj.privateField); // ERROR
        // obj.privateMethod();                  // ERROR

        obj.testInternalAccess();

        SamePackageTest.testAccess();
    }
}
