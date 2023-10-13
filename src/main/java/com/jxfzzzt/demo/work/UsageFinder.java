package com.jxfzzzt.demo.work;

import com.jxfzzzt.demo.util.SootUtil;

public class UsageFinder {

    public static final String SRC_PATH = "src/main/resources/test-demo/target/classes";
    public static String circleClassName = "com.demo.test.UsageExample";
    public static void main(String[] args) {
        SootUtil.generalInitial(SRC_PATH);

        String usageMethodSubsignature = "void println(java.lang.String)";
        String usageClassSignature = "java.io.PrintStream";

    }
}
