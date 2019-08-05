package az.aris.vsb_CompanyWished.util;


import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import az.aris.vsb_CompanyWished.db.service.DatabaseService;
import com.hazelcast.core.IMap;
import com.hazelcast.core.ISet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class HazelcastUtility {
    @Autowired
    DatabaseService databaseService;
    @Autowired
    IMap<Long, CompanyWished> mapOfCompanyWished;
    @Autowired
    ISet<CompanyWished> setOfCompanyWished;
    @Autowired
    IMap<Long, List<CompanyWished>> mapOfIdDriver;
    @Autowired
    IMap<Long, List<CompanyWished>> mapOfIdCompany;
    @Autowired
    IMap<Date, List<CompanyWished>> mapOfRequestDate;

    public void startCaching() {
        List<CompanyWished> companyWishedList = databaseService.findAllAsList();
        for (CompanyWished companyWished : companyWishedList) {
            mapOfCompanyWished.put(companyWished.getIdCompanyWished(), companyWished);
            setOfCompanyWished.add(companyWished);
            mapOfIdDriver.put(companyWished.getIdDriver(), databaseService.findByIdDriver(companyWished.getIdDriver()));
            mapOfIdCompany.put(companyWished.getIdCompany(), databaseService.findByIdCompany(companyWished.getIdCompany()));
            mapOfRequestDate.put(companyWished.getRequestDate(), databaseService.findByRequestDate(companyWished.getRequestDate()));

        }
    }

    public CompanyWished save(CompanyWished companyWished) throws Exception {
        companyWished = databaseService.insertUpdate(companyWished);
        mapOfCompanyWished.put(companyWished.getIdCompanyWished(), companyWished);
        setOfCompanyWished.add(companyWished);

        return companyWished;
    }
    public void deleteCompanyWished(Long idCompanyWished) throws Exception {
        setOfCompanyWished.remove(mapOfCompanyWished.get(idCompanyWished));
        mapOfCompanyWished.remove(idCompanyWished);
        databaseService.removeCompanyWished(idCompanyWished);
    }


    public List<CompanyWished> getIdDriver(Long idDriver) throws Exception {
        List<CompanyWished> companyWisheds;
        if (mapOfIdDriver.isEmpty()) {
            startCaching();
        }
        companyWisheds= mapOfIdDriver.get(idDriver);
        if (companyWisheds == null) {
            startCaching();
        }
        return mapOfIdDriver.get(idDriver);
    }
    public CompanyWished getCompanyWished(Long idCompanyWished) throws Exception {
        CompanyWished  companyWished;
        if (mapOfCompanyWished.isEmpty()) {
            startCaching();
        }
        companyWished= mapOfCompanyWished.get(idCompanyWished);
        if (companyWished == null) {
            startCaching();
        }
        return mapOfCompanyWished.get(idCompanyWished);
    }
    public List<CompanyWished> getİdCompany(Long idCompany) throws Exception {
        List<CompanyWished> companyWisheds;
        if (mapOfIdCompany.isEmpty()) {
            startCaching();
        }
        companyWisheds= mapOfIdCompany.get(idCompany);
        if (companyWisheds == null) {
            startCaching();
        }
        return mapOfIdCompany.get(idCompany);
    }
    public List<CompanyWished> getRequestDate(Date requestDate) throws Exception{
        List<CompanyWished>companyWisheds;
        if (mapOfRequestDate.isEmpty()){
            startCaching();
        }
        companyWisheds = mapOfRequestDate.get(requestDate);
        if (companyWisheds == null){
            startCaching();
        }
        return mapOfRequestDate.get(requestDate);
    }

    public List<CompanyWished> getCompanyWisheds() throws Exception{
        if(mapOfCompanyWished.isEmpty()){
            startCaching();
        }

        List<CompanyWished> list = new ArrayList<>();
        for (Long idCompanyWished : mapOfCompanyWished.keySet()) {
            list.add(mapOfCompanyWished.get(idCompanyWished));
        }
        return list;
    }

}