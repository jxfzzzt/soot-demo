package com.jxfzzzt.demo.work;

import com.jxfzzzt.demo.util.SootUtil;
import soot.*;
import soot.jimple.JimpleBody;
import soot.jimple.internal.JIfStmt;

public class HelloSoot01 {

    public static final String SRC_PATH = "/Users/zhouzhuotong/java_projects/soot-demo/src/main/resources/test-demo/target/classes";

    public static final String CLASS_NAME = "com.demo.test.FizzBuzz";

    public static final String METHOD_NAME = "printFizzBuzz";

    public static void main(String[] args) {
        SootUtil.generalInitial(SRC_PATH);

        SootClass sootClass = Scene.v().getSootClass(CLASS_NAME);
        SootMethod sm = sootClass.getMethodByName(METHOD_NAME);

        JimpleBody jimpleBody = (JimpleBody) sm.retrieveActiveBody();
        System.out.println(jimpleBody.toString());
        System.out.println("Method Signature: " + sm.getSignature());
        System.out.println("--------------");
        System.out.println("Argument(s):");
        for (Local local : jimpleBody.getParameterLocals()) {
            System.out.println(local.getName() + " ------ " + local.getType());
        }

        System.out.println("--------------");
        System.out.println("This: " + jimpleBody.getThisLocal());
        System.out.println("--------------");
        System.out.println("Units:");
        int c = 1;
        for (Unit u : jimpleBody.getUnits()) {
            System.out.println("(" + c + ") " + u.toString());
            c++;
        }

        System.out.println("--------------");
        // Print statements that have branch conditions
        System.out.println("Branch Statements:");
        for (Unit u : jimpleBody.getUnits()) {
            if (u instanceof JIfStmt)
                System.out.println(u.toString());
        }
    }
}
