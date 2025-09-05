package personal.clone;

public class MyClass implements Cloneable {
    private String str;
    private int num;

    public MyClass(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "str='" + str + '\'' +
                ", num=" + num +
                '}';
    }

    //following is ok without implements the Cloneable
//    @Override
//    protected MyClass clone(){
//        return null;
//    }


    //this is infinite loo;
//    @Override
//    protected MyClass clone(){
//        return this.clone();
//    }

    //this throw CloneNotSupportedException exception if Cloneable is not implemented
    @Override
    protected MyClass clone() throws CloneNotSupportedException {
        return (MyClass) super.clone();
    }
}
