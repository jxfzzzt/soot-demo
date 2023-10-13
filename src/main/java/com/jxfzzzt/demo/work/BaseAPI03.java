package com.jxfzzzt.demo.work;

import com.jxfzzzt.demo.util.SootUtil;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

import java.util.Iterator;

public class BaseAPI03 {

    public static final String SRC_PATH = "src/main/resources/test-demo/target/classes";

    public static String CLASS_NAME = "com.demo.test.GraphTest";
    public static String METHOD_NAME = "getSecret";

    public static void main(String[] args) {
        SootUtil.generalInitial(SRC_PATH);
        SootClass sootClass = Scene.v().getSootClass(CLASS_NAME);
        SootMethod method = sootClass.getMethodByName(METHOD_NAME);

        // Call Graph
        System.out.println("-----CallGraph-----");
        CallGraph callGraph = Scene.v().getCallGraph();
        for (Iterator<Edge> it = callGraph.edgesInto(method); it.hasNext(); ) { // 枚举哪些函数调用了当前函数getSecret
            Edge edge = it.next();
            System.out.println(String.format("Method '%s' invokes method '%s' through stmt '%s", edge.src(), edge.tgt(), edge.srcUnit()));
        }
    }
}
