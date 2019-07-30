package az.aris.vsb_CompanyWished.api.SearchService;

import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import az.aris.vsb_CompanyWished.util.HazelcastUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HazelcastUtility hazelcastUtility;
    @Autowired
    SearchInternal searchInternal;

    @GetMapping("/getCompanyWished/{idCompanyWished}")
    public ResponseEntity<CompanyWished> getIdCompanyWished(@PathVariable("idCompanyWished") long idCompanyWished) throws Exception {
        logger.info("{}", "getting CompanyWished by id from hazelcast...");
        return searchInternal.getIdCompanyWished(idCompanyWished);
    }

    @GetMapping("/getDriver/{idDriver}")
    public ResponseEntity<List<CompanyWished>> getIdDriver(@PathVariable("idDriver") long idDriver) throws Exception {
        logger.info("{}", "getting Driver by id from hazelcast...");
        return searchInternal.getIdDriver(idDriver);
    }

    @GetMapping("/getIdCompany/{idCompany}")
    public ResponseEntity<List<CompanyWished>> getIdCompany(@PathVariable("idCompany") long idCompany) throws Exception {
        logger.info("{}", "getting Company by id from hazelcast...");
        return searchInternal.getIdCompany(idCompany);
    }

    @GetMapping("/getRequestDate/{requestDate}")
    public ResponseEntity<List<CompanyWished>> getRequestDate(@PathVariable("requestDate") Date requestDate) throws Exception {
        logger.info("{}", "getting Request Date by id from hazelcast...");
        return searchInternal.getRequestDate(requestDate);
    }
}