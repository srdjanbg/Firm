package application.models;

/**
 *
 * @author Srdjan
 */
public class DutiesModel {
    
    private Integer id;
    private String oblast;
    private String nivo;
    private Integer employeeId;

    public DutiesModel() {
    }

    public DutiesModel(Integer id, String oblast, String nivo, Integer employeeId) {
        this.id = id;
        this.oblast = oblast;
        this.nivo = nivo;
        this.employeeId = employeeId;
    }

    public DutiesModel(String oblast, String nivo, Integer employeeId) {
        this.oblast = oblast;
        this.nivo = nivo;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    
    
    
    
    
    
}

