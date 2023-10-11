package com.jxfzzzt.demo.work;

import com.jxfzzzt.demo.util.SootUtil;
import soot.*;
import soot.JastAddJ.ForStmt;
import soot.JastAddJ.WhileStmt;
import soot.jimple.JimpleBody;
import soot.jimple.internal.JIfStmt;

public class HelloSoot02 {
    public static final String SRC_PATH = "/Users/zhouzhuotong/java_projects/soot-demo/src/main/resources/test-demo/target/classes";

    public static final String CLASS_NAME = "com.demo.test.FizzBuzz";

    public static final String METHOD_NAME = "fizzBuzz";

    public static void main(String[] args) {
        SootUtil.generalInitial(SRC_PATH);

        SootClass sootClass = Scene.v().getSootClass(CLASS_NAME);
        SootMethod method = sootClass.getMethodByName(METHOD_NAME);

        JimpleBody jimpleBody = (JimpleBody)method.retrieveActiveBody();

        System.out.println(jimpleBody);
        for(Local local : jimpleBody.getLocals()) {
            System.out.println(local.getName() + " ------ " + local.getType());
        }

        // 源代码的for循环也会变成 JIfStmt
        System.out.println("--------------");
        for (Unit unit : jimpleBody.getUnits()) {
            if(unit instanceof JIfStmt) {
                System.out.println(unit);
            }
        }
    }
}
