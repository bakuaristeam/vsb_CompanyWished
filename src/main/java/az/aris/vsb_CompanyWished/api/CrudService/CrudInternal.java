package az.aris.vsb_CompanyWished.api.CrudService;

import az.aris.vsb_CompanyWished.api.SaveUpdate;
import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import az.aris.vsb_CompanyWished.db.repo.Repo;
import az.aris.vsb_CompanyWished.db.service.DatabaseService;
import az.aris.vsb_CompanyWished.util.HazelcastUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CrudInternal {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DatabaseService databaseService;
    @Autowired
    Repo repo;
    @Autowired
    HazelcastUtility hazelcastUtility;

    public ResponseEntity<CompanyWished> saveCompanyWished(SaveUpdate saveUpd) {
        try {
            CompanyWished companyWished = new CompanyWished();

            companyWished.setIdDriver(saveUpd.getIdDriver());
            companyWished.setIdCompany(saveUpd.getIdCompany());
            companyWished.setRequestDate(saveUpd.getRequestDate());
            companyWished.setIsActive(saveUpd.getIsActive());
            companyWished.setNote(saveUpd.getNote());

            companyWished.setIsActive(1);

            companyWished = hazelcastUtility.save(companyWished);
            logger.info("{}", "Saving CompanyWished");
            return new ResponseEntity<>(companyWished, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("{}", "Error Saving DriverInfo", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CompanyWished> updateCompanyWished(SaveUpdate saveUpd) throws Exception {
        CompanyWished companyWished = repo.findByIdCompanyWished(saveUpd.getIdCompanyWished());

        try {

            companyWished.setIdDriver(saveUpd.getIdDriver());
            companyWished.setIdCompany(saveUpd.getIdCompany());
            companyWished.setNote(saveUpd.getNote());
            companyWished.setRequestDate(saveUpd.getRequestDate());
            companyWished.setIsActive(saveUpd.getIsActive());

            databaseService.insertUpdate(companyWished);
            logger.info("{}", "Update CompanyWished");
            return new ResponseEntity<>(companyWished, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("{}", "Error Update CompanyWished", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CompanyWished> deleteCompanyWished(Long idCompanyWished) throws Exception{
        CompanyWished companyWished = new CompanyWished();
        try {
            hazelcastUtility.deleteCompanyWished(idCompanyWished);
            logger.info("{} : {}","Delete CompanyWished",idCompanyWished);
            return new ResponseEntity<>(companyWished,HttpStatus.OK);
        }catch (Exception e){
            logger.info("{} : {}","Error delete CompanyWished",e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

