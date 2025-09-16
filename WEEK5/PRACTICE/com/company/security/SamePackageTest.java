package WEEK5.PRACTICE.com.company.security;



class SamePackageTest {
    public static void testAccess() {
        System.out.println("\n--- Inside SamePackageTest ---");
        AccessModifierDemo obj = new AccessModifierDemo(1, "pkg", 2.5, false);

        // private: not accessible
        // System.out.println(obj.privateField); // ERROR
        // obj.privateMethod();                  // ERROR

        // default & protected: accessible (same package)
        System.out.println("defaultField   = " + obj.defaultField);
        System.out.println("protectedField = " + obj.protectedField);
        obj.defaultMethod();
        obj.protectedMethod();

        // public: always accessible
        System.out.println("publicField    = " + obj.publicField);
        obj.publicMethod();
    }
}

