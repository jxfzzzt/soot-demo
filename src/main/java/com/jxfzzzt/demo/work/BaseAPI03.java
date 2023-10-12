package com.jxfzzzt.demo.work;

import com.jxfzzzt.demo.util.SootUtil;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

import java.util.List;

public class BaseAPI03 {

    public static final String SRC_PATH = "src/main/resources/test-demo/target/classes";

    public static final String CLASS_NAME = "com.demo.test.GraphTest";


    public static void main(String[] args) {
        SootUtil.generalInitial(SRC_PATH);
        Chain<SootClass> classes = Scene.v().getClasses();
        for(SootClass sootClass : classes) {
            if(sootClass.getName().startsWith("com.demo.")) {
                System.out.println("============================");
                List<SootMethod> methods = sootClass.getMethods();
                for(SootMethod method : methods) {
                    System.out.println(method.getSignature() + " \t" + method.getSubSignature() + " \t" + method.getSource());
                }
            }
        }
    }
}
