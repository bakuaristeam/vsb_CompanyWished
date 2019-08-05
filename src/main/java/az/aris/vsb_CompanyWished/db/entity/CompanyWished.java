package az.aris.vsb_CompanyWished.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class CompanyWished implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompanyWished", nullable = false, unique = true)
    private long idCompanyWished;
    private long idDriver;
    private long idCompany;
    private Date requestDate;
    private int isActive;
    private String Note;

    public CompanyWished(long idDriver, long idCompany, Date requestDate, int isActive, String note) {
        this.idDriver = idDriver;
        this.idCompany = idCompany;
        this.requestDate = requestDate;
        this.isActive = isActive;
        Note = note;
    }

    public CompanyWished() {
    }

    @Override
    public String toString() {
        return "CompanyWished{" +
                "idCompanyWished=" + idCompanyWished +
                ", idDriver=" + idDriver +
                ", idCompany=" + idCompany +
                ", requestDate=" + requestDate +
                ", isActive=" + isActive +
                ", Note='" + Note + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getIdCompanyWished() {
        return idCompanyWished;
    }

    public void setIdCompanyWished(long idCompanyWished) {
        this.idCompanyWished = idCompanyWished;
    }

    public long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(long idDriver) {
        this.idDriver = idDriver;
    }

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
