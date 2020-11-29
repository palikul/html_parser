package pentalog.hack.controller;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

public class TestClass {

    TestClass() {
        parentMethod();
    }

    protected void parentMethod() {
        System.out.println("ParentMethod");
    }

}

class TestClassChile extends TestClass {

    @Override
    protected void parentMethod() {
        System.out.println("ParentMethod overridden");
    }

    public static void main(String[] args) throws IOException {
        System.runFinalization();
//        IntStream.range(0,1000000).forEach(value -> new TestClassChile());
//        System.runFinalization();

        TestClass testClass = new TestClass();

    }

    @Override
    protected void finalize() throws IOException {
        this.parentMethod();
    }

    @Override
    public final boolean equals(Object o) {
        return true;
    }
}


interface Foo {
    void doFoo();
}

class FooImpl implements Foo {
    @Override
    public void doFoo() {
        //.. Do important code
    }
}

class Bar {
    private FooImpl fi;

    public Bar() {
        fi = new FooImpl();
        fi.doFoo(); // The message complains about this line
    }
}