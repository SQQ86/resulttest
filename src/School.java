import java.io.IOException;
import java.util.*;

public class School {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        Person[] people = new Person[a];
        for (int i = 0; i < a; i++) {
            people[i]= new Person(scan.next(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());


        }
        double matSred = 0.0,rusSred =0.0,infSred =0.0;


        for (int i = 0; i < a; i++) {
            matSred+= people[i].mat;
            rusSred+=people[i].rus;
            infSred+=people[i].inf;

        }
        matSred = matSred/a;
        rusSred = rusSred/a;
        infSred = infSred/a;
        double allSred = (matSred+rusSred+infSred)/3;
        Sch [] sch = new Sch[a];
        for (int i = 0; i <a ; i++) {
            sch[i] = new Sch(people[i].sc, people[i].mat,people[i].rus,people[i].inf,(double) (people[i].mat+people[i].rus+people[i].inf)/3);
        }
        Comparator <Sch> schComp = new scComp();
        Arrays.sort(sch, schComp);
        int count =1;
        for (int i = 0; i < sch.length; i++) {
            count=1;

            if (sch[i].scNumb !=0) {
                for (int j = i + 1; j < sch.length; j++) {
                    if (sch[i].scNumb == sch[j].scNumb && !(sch[j].scNumb == 0)) {
                        sch[i].all += sch[j].all;
                        sch[i].inf += sch[j].inf;
                        sch[i].mat += sch[j].mat;
                        sch[i].rus += sch[j].rus;
                        count+=1;

                        sch[j].scNumb = 0;


                    }


                }

            }sch[i].all /= count;
            sch[i].rus /= count;
            sch[i].mat /= count;
            sch[i].inf /= count;

        }
        Comparator <Sch> scCompObr = new scCompObr();
        Arrays.sort(sch, scCompObr);
        Comparator <Sch> allComp = new allComp();
        Arrays.sort(sch, allComp);
        System.out.printf(Locale.ENGLISH,"Отчет по городу: математика - %.1f, русский язык - %.1f, инфрматика - %.1f, общий средний балл - %.1f %n", matSred,rusSred,infSred,allSred);
        System.out.println("Отчет по школам:");
        for (int i = 0; i <sch.length ; i++) {
            if (sch[i].scNumb > 0) {
                System.out.printf(Locale.ENGLISH, "Школа № %d: математика - %.1f, русский язык - %.1f, инфрматика - %.1f, общий средний балл - %.1f %n", sch[i].scNumb, sch[i].mat, sch[i].rus, sch[i].inf, sch[i].all);
            }
        }
        Comparator <Person> matComp = new matComp();
        Arrays.sort(people, matComp);
        System.out.printf("Лучший результат по математике - %s %s - %d %n", people[0].name, people[0].lastname, people[0].mat);
        for (int i = 1; i <people.length ; i++) {
            if (people[i-1].mat==people[i].mat){
                System.out.printf("Лучший результат по математике - %s %s - %d %n", people[i].name, people[i].lastname, people[i].mat );
            }
            else break;

        }
        Comparator <Person> rusComp = new rusComp();
        Arrays.sort(people, rusComp);
        System.out.printf("Лучший результат по русскому языку - %s %s - %d %n", people[0].name, people[0].lastname, people[0].rus);
        for (int i = 1; i <people.length ; i++) {
            if (people[i-1].rus==people[i].rus){
                System.out.printf("Лучший результат по русскому языку - %s %s - %d %n", people[i].name, people[i].lastname, people[i].rus );
            }
            else break;

        }
        Comparator <Person> infComp = new infComp();
        Arrays.sort(people, infComp);
        System.out.printf("Лучший результат по информатике - %s %s - %d %n", people[0].name, people[0].lastname, people[0].inf);
        for (int i = 1; i <people.length ; i++) {
            if (people[i-1].inf==people[i].inf){
                System.out.printf("Лучший результат по информатике - %s %s - %d %n", people[i].name, people[i].lastname, people[i].inf );
            }
            else break;

        }
    }



}
class allComp implements Comparator <Sch> {
    public int compare (Sch a, Sch b){
        if (a.getAll()<b.getAll()){
            return 1;
        }
        if (a.getAll()> b.getAll()){
            return -1;
        }
        else return 0;
    }

}
class scComp implements Comparator <Sch>{
    public int compare (Sch a, Sch b){
        if (a.getScNumb()<b.getScNumb()){
            return -1;
        }
        if (a.getScNumb()>b.getScNumb()){
            return 1;
        }
        else return 1;
    }
}
class scCompObr implements Comparator <Sch>{
    public int compare (Sch a, Sch b){
        if (a.getScNumb()<b.getScNumb()){
            return 1;
        }
        if (a.getScNumb()>b.getScNumb()){
            return -1;
        }
        else return 1;
    }
}
class infComp implements Comparator <Person>{
    public int compare (Person a, Person b){
        if (a.getInf()<b.getInf()){
            return 1;
        }
        if (a.getInf()>b.getInf()){
            return -1;
        }
        else return 0;

    }
}
class matComp implements Comparator <Person>{
    public int compare (Person a, Person b){
        if (a.getMat()<b.getMat()){
            return 1;
        }
        if (a.getMat()>b.getMat()){
            return -1;
        }
        else return 0;

    }
}
class rusComp implements Comparator <Person>{
    public int compare (Person a, Person b){
        if (a.getRus()<b.getRus()){
            return 1;
        }
        if (a.getRus()>b.getRus()){
            return -1;
        }
        else return 0;

    }
}


