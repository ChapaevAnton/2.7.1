public class MyCat {
    String name;
    int age;
    float mass;

    public MyCat(String name) {
        this.name = name;
    }

    public MyCat(String name, int age) {
        this(name);
        this.age = age;
    }

    public MyCat(String name, int age, float mass) {
        this(name, age);
        this.mass = mass;
    }

    @Override
    public String toString() {
        return String.format("Моего кота звать %1$1s, его возраст %2$d и вес %3$.2f",this.name,this.age,this.mass);
    }

    public static void main(String[] args) {

        MyCat cat1 = new MyCat("Барсик");
        System.out.println(cat1);
        MyCat cat2 = new MyCat("Мурзик",3,5.34f);
        System.out.println(cat2);

    }
}
