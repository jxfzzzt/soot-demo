package com.jxfzzzt.demo.work;

import soot.Scene;
import soot.SootClass;
import soot.options.Options;

import java.util.Collections;

public class Main01 {

    public static final String SRC_PATH = "G:\\java_projects\\soot-demo\\src\\main\\java\\com\\jxfzzzt\\demo\\domain";

    public static void main(String[] args) {
        initial(SRC_PATH);
        SootClass appclass = Scene.v().loadClassAndSupport("TestMain");//若无法找到，则生成一个。
        appclass.setApplicationClass();
        System.out.println("the main class is :" + appclass.getName());

    }

    private static void initial(String srcPath) {
        soot.G.reset();
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_prepend_classpath(true);
        Options.v().set_validate(true);
        Options.v().set_output_format(Options.output_format_jimple);
        Options.v().set_src_prec(Options.src_prec_java);
        Options.v().set_process_dir(Collections.singletonList(srcPath));//路径应为文件夹
        Options.v().set_keep_line_number(true);
		Options.v().set_whole_program(true);
        Options.v().set_no_bodies_for_excluded(true);
        Options.v().set_app(true);
//		 Scene.v().setMainClass(appclass); // how to make it work ?

        Scene.v().addBasicClass("java.io.PrintStream", SootClass.SIGNATURES);
        Scene.v().addBasicClass("java.lang.System", SootClass.SIGNATURES);
        Scene.v().addBasicClass("java.lang.Thread", SootClass.SIGNATURES);
        Scene.v().loadNecessaryClasses();
    }
}
