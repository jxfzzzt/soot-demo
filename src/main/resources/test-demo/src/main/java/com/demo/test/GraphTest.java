package com.demo.test;

public class GraphTest {
    GraphTest() {

    }

    public String getSecret(String x) {
        vulFunc(x);
        return "secret";
    }

    public void vulFunc(String x) {
        System.out.println("This is a Vulnerable Function. Param: " + x);
    }

    public String process(String x) {
        return getSecret(x);
    }

}
