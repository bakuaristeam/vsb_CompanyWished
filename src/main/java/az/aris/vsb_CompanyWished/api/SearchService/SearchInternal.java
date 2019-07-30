package az.aris.vsb_CompanyWished.api.SearchService;

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

import java.sql.Date;
import java.util.List;

@Component
public class SearchInternal {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DatabaseService databaseService;
    @Autowired
    Repo repo;
    @Autowired
    HazelcastUtility hazelcastUtility;

    public ResponseEntity<CompanyWished> getIdCompanyWished(Long idCompanyWished) throws Exception {
        CompanyWished companyWished;
        try {
            companyWished = hazelcastUtility.getCompanyWished(idCompanyWished);
            if (companyWished == null) {
                logger.info("{}", "No content getting CompanyWished in idCompanyWished");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                logger.info("{}", "Getting CompanyWished from hazelcast...");
                return new ResponseEntity<>(companyWished, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error : {}", "Not Found IdCompanyWished", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<CompanyWished>> getIdDriver(Long idDriver) throws Exception {
        List<CompanyWished> companyWished;
        try {
            companyWished = hazelcastUtility.getIdDriver(idDriver);
            if (companyWished == null) {
                logger.info("{}", "No content getting CompanyWished Info in IdDriver");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                logger.info("{}", "Getting CompanyWished by Property from hazelcast...");
                return new ResponseEntity<>(companyWished, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error: {}", "Not Found IdCompanyWished in IdDriver ", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<CompanyWished>> getIdCompany(Long idCompany) throws Exception {
        List<CompanyWished> companyWished;
        try {
            companyWished = hazelcastUtility.getİdCompany(idCompany);
            if (companyWished == null) {
                logger.info("{}", "No content getting CompanyWished  in IdCompany");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                logger.info("{}", "Getting idCompany by Property from hazelcast...");
                return new ResponseEntity<>(companyWished, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error: {}", "Not Found IdCompanyWished in idCompany", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<CompanyWished>> getRequestDate(Date requestDate) throws Exception {
        List<CompanyWished> companyWished;
        try {
            companyWished = hazelcastUtility.getRequestDate(requestDate);
            if (companyWished == null) {
                logger.info("{}", "No content getting CompanyWished  in requestDate");
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                logger.info("{}", "Getting RequestDate by Property from hazelcast...");
                return new ResponseEntity<>(companyWished, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error: {}", "Not Found IdCompanyWished in RequestDate", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
