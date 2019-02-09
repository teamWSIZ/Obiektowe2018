package wsi.exec.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class B {
    String name;
}

public class A {
    public static void main(String[] args) {
        B a = new B("karramba");
        B a1 = new B("karramba");
        System.out.println(a.hashCode());
        System.out.println(a1.hashCode());
    }
}
