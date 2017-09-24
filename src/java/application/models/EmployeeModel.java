package application.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Srdjan
 */
public class EmployeeModel {
    

    private Integer id;

    @Size(min = 3, max = 30, message = "Ime zaposlenog mora biti duzine izmedju 3 i 30 karaktera")
    private String ime;

    @Size(min = 3, max = 30, message = "Prezime mora biti duzine izmedju 3 i 30 karaktera")
    private String prezime;

    @NotNull(message = "Name cannot be null")
    private String pozicija;

    @Range(min = 25000, max = 1000000, message = "Plata mora biti izmedju 25000 i 1000000")
    private Integer plata;

    
    private String staz;
    
    private String oblast;
    
    private String nivo;

    public EmployeeModel() {
    }

   /* public EmployeeModel(Integer id, String ime, String prezime, String pozicija, Integer plata, String staz, String oblast, String nivo) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.plata = plata;
        this.staz = staz;
        this.oblast = oblast;
        this.nivo = nivo;
    }*/

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }
    
    
    

   public EmployeeModel(Integer id, String ime, String prezime, String pozicija, Integer plata, String staz) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.plata = plata;
        this.staz = staz;
    }

    public EmployeeModel(String ime, String prezime, String pozicija, Integer plata, String staz) {
        this.ime = ime;
        this.prezime = prezime;
        this.pozicija = pozicija;
        this.plata = plata;
        this.staz = staz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

}
