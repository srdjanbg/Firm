package application.domains;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Srdjan
 */
@Entity(name = "Employee")
@Table(name = "zaposleni")
public class Employee implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ime;

    private String prezime;

    @Column(name = "pozicija_u_firmi")
    private String pozicija;

    private Integer plata;

    @Column(name = "staz_u_firmi")
    private String staz;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Duties> duties = new HashSet<Duties>();

   
    public Employee(String ime, String prezime, String pozicija, Integer plata, String staz, Set<Duties> duties) {
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.plata = plata;
        this.staz = staz;
        this.duties = duties;
    }

    public Employee(String ime, String prezime, String pozicija, Integer plata, String staz) {
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.plata = plata;
        this.staz = staz;
        this.duties = duties;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Integer getPlata() {
        return plata;
    }

    public void setPlata(Integer plata) {
        this.plata = plata;
    }

    public String getStaz() {
        return staz;
    }

    public void setStaz(String staz) {
        this.staz = staz;
    }
}
