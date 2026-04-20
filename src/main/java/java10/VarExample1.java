package java10;

import java.util.Optional;

public class VarExample1 {

    //var a = 10; // compilation error. can not be declared as instance varible at class level
    public static void main(String[] args) {
        VarExample1 ve = new VarExample1();
        ve.varDemo("grey");

    }

    //private void varDemo(var s) { //compilation error. can not use as method parameter
    private void varDemo(String d) {
        var s = "method level";
        var a = 10;
        var b = 20;
        if(a*b != 30) {
            var c = 10;
            System.out.println(c);
        }
        var i = 10;
        Optional.ofNullable(s).orElseThrow();
        System.out.println(s + i);
    }
}
