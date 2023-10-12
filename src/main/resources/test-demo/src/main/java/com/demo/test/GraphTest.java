package com.demo.test;

public class GraphTest {
    GraphTest() {

    }

    private String getSecret(String x) {
        vulFunc(x);
        return "secret";
    }

    private void vulFunc(String x) {
        System.out.println("This is a Vulnerable Function. Param: " + x);
    }

    public String process(String x) {
        return getSecret(x);
    }

}
