package myUselessaTesting;

public class B {

    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public B(String name, int number) {
        this.name=name;
        this.number=number;
    }

    public  static void main(String[] args){
        A a=new A("abid",124342,"abid@gmail.com",24);
        B b= (B) a;
        System.out.println(b.getName());

    }

}
