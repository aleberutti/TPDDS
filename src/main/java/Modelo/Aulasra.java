package Modelo;
// Generated Oct 22, 2017 10:44:08 PM by Hibernate Tools 4.3.1



/**
 * Aulasra generated by hbm2java
 */
public class Aulasra extends Aula implements java.io.Serializable {


     private Integer aulaId;
     private Aula aula;

    public Aulasra() {
    }

    public Aulasra(Aula aula) {
       this.aula = aula;
    }
   
    public Integer getAulaId() {
        return this.aulaId;
    }
    
    public void setAulaId(Integer aulaId) {
        this.aulaId = aulaId;
    }
    public Aula getAula() {
        return this.aula;
    }
    
    public void setAula(Aula aula) {
        this.aula = aula;
    }




}


