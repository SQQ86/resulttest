public class Person {
    String lastname,name;
    int sc,mat,rus,inf;

    public Person(String name, String lastname, int sc, int mat, int rus, int inf) {
        this.lastname = lastname;
        this.name = name;
        this.sc = sc;
        this.mat = mat;
        this.rus = rus;
        this.inf = inf;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", sc=" + sc +
                ", mat=" + mat +
                ", rus=" + rus +
                ", inf=" + inf +
                '}';
    }
    int getMat () {return mat;}
    int getRus (){return rus;}
    int getInf () {return inf;}

}
