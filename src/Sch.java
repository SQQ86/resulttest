public class Sch {
    int scNumb;
    double mat,rus,inf,all;

    public Sch(int scNumb, double mat, double rus, double inf, double all) {
        this.scNumb = scNumb;
        this.mat = mat;
        this.rus = rus;
        this.inf = inf;
        this.all = all;
    }
    Double  getAll () {
        return all;

    }
    int getScNumb(){
        return scNumb;
    }

    @Override
    public String toString() {
        return "Школа № /%n" +
                "scNumb=" + scNumb +
                ", mat=" + mat +
                ", rus=" + rus +
                ", inf=" + inf +
                ", all=" + all +
                '}';
    }
}
