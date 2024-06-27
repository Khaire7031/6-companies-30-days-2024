
@FunctionalInterface
interface ABC {
    void show();
    // void read();
}

class A {
    public void showDataBelongsToThisClass() {
        System.out.println("In A");
    }

}

class B extends A {
    public void showDataBelongsToThisClass() {
        System.out.println("In B");
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println("Pranav");
        ABC obj = new ABC() {
            public void show() {
                System.out.println("In Show");
            }
        };
        obj.show();
    }
}