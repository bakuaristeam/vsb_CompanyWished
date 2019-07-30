package az.aris.vsb_CompanyWished.db.service;

import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import az.aris.vsb_CompanyWished.db.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class DatabaseService {
    @Autowired
    Repo repo;
    public CompanyWished insertUpdate(CompanyWished companyWished) throws Exception {
        companyWished= repo.save(companyWished);
        return companyWished;
    }

    public List<CompanyWished> findAllAsList() {
        return repo.findAll();
    }
    public List<CompanyWished> findByIdDriver(Long idDriver) {
        return repo.findByIdDriver(idDriver);
    }
    public List<CompanyWished> findByIdCompany(Long idCompany) {
        return repo.findByIdCompany(idCompany);
    }
    public List<CompanyWished> findByRequestDate(Date requestDate) {
        return repo.findByRequestDate(requestDate);
    }
    public void removeCompanyWished(Long idCompanyWished)throws Exception{
        CompanyWished companyWished= repo.findByIdCompanyWished(idCompanyWished);
        repo.delete(companyWished);
    }

}
