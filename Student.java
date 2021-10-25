public class Student {
    private final String nume;        //numele studentului
    private final String prenume;     //prenumele studentului
    private final String nrMatricol;  //nr matricol al studentului
    private int nota;                 //nota student

    public Student (String nume, String prenume, String nrMatricol){      //constructor pt ob student
        this.nume = nume;
        this.prenume = prenume;
        this.nrMatricol = nrMatricol;
}
 public String getNrMatricol(){
        return this.nrMatricol;
 }

 public int getNota(){
        return this.nota;
 }

 public void SetNota(int nr){
        this.nota+=nr;
        while(nota>nr){
    nota--;
}
 }
    public String toString(){
       StringBuffer res=new StringBuffer("nume: ");
       res.append(nume);
       res.append("   prenume: ");
       res.append(prenume);
        //res.append("    Nr matricol:  ");
        // res.append(nrMatricol);
       return res.toString();
    }
}

