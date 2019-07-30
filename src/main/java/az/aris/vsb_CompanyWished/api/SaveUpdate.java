package az.aris.vsb_CompanyWished.api;

import java.sql.Date;

public class SaveUpdate {
    private long idCompanyWished;
    private long idDriver;
    private long idCompany;
    private Date requestDate;
    private int isActive;
    private String note;

    public SaveUpdate(long idCompanyWished, long idDriver, long idCompany, Date requestDate, int isActive, String note) {
        this.idCompanyWished = idCompanyWished;
        this.idDriver = idDriver;
        this.idCompany = idCompany;
        this.requestDate = requestDate;
        this.isActive = isActive;
        this.note = note;
    }

    public SaveUpdate() {
    }

    @Override
    public String toString() {
        return "SaveUpdate{" +
                "idCompanyWished=" + idCompanyWished +
                ", idDriver=" + idDriver +
                ", idCompany=" + idCompany +
                ", requestDate=" + requestDate +
                ", isActive=" + isActive +
                ", note='" + note + '\'' +
                '}';
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
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
