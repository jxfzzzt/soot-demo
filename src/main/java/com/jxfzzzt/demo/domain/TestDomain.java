package com.jxfzzzt.demo.domain;

public class TestDomain {
    public static void main(String[] args) {
        C(1);
    }

    public static void A() {
        System.out.println("<" + TestDomain.class.getName() + "> inside A");
    }

    public static void B() {
        System.out.println("<" + TestDomain.class.getName() + "> inside B");
    }

    public static void C(int i) {
        if (i > 1) {
            A();
        } else {
            B();
        }
    }
}
