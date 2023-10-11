package com.jxfzzzt.demo.work;

import com.jxfzzzt.demo.util.SootUtil;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;

import java.util.Iterator;

public class BaseAPI02 {

    public static final String SRC_PATH = "src/main/resources/test-demo/target/classes";
    public static String circleClassName = "com.demo.test.Circle";
    public static String areaMethodName = "int area(boolean)";

    public static void main(String[] args) {
        SootUtil.generalInitial(SRC_PATH);
        SootClass sootClass = Scene.v().getSootClass(circleClassName);
        SootMethod areaMethod = sootClass.getMethod(areaMethodName);

        // Call Graph
        System.out.println("-----CallGraph-----");
        CallGraph callGraph = Scene.v().getCallGraph();
        for (Iterator<Edge> it = callGraph.edgesOutOf(areaMethod); it.hasNext(); ) { // 枚举当前函数调用了哪些别的函数
            Edge edge = it.next();
            System.out.println(String.format("Method '%s' invokes method '%s' through stmt '%s", edge.src(), edge.tgt(), edge.srcUnit()));
        }
    }
}
