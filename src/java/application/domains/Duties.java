package application.domains;

import static com.oracle.util.Checksums.update;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Srdjan
 */
@Entity(name = "Duties")
@Table(name = "zaduzenja")
public class Duties implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String oblast;

    private String nivo;

@Column(name="employee_id")
    private int employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    public Duties() {
    }
    

    public Duties(String oblast, String nivo, int employeeId) {
        this.oblast = oblast;
        this.nivo = nivo;
        this.employeeId = employeeId;
    }

    public Duties(String oblast, String nivo, int employeeId, Employee employee) {
        this.oblast = oblast;
        this.nivo = nivo;
        this.employeeId = employeeId;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

}
