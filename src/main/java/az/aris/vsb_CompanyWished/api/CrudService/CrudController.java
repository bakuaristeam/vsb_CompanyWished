package az.aris.vsb_CompanyWished.api.CrudService;

import az.aris.vsb_CompanyWished.api.SaveUpdate;
import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CrudController {
    @Autowired
    CrudInternal crudInternal;
    @PostMapping("/add")
    public ResponseEntity<CompanyWished> saveCompanyWished(@RequestBody SaveUpdate saveUpd) {
        return crudInternal.saveCompanyWished(saveUpd);
    }

    @PostMapping("/update")
    public ResponseEntity<CompanyWished> updateCompanyWished(@RequestBody SaveUpdate saveUpd) throws Exception {
        return crudInternal.updateCompanyWished(saveUpd);
    }

    @GetMapping("/delete/{idCompanyWished}")
    public ResponseEntity<CompanyWished> deleteCompanyWished(@PathVariable("idCompanyWished") long idCompanyWished) throws Exception {
        return crudInternal.deleteCompayWished(idCompanyWished);
    }
}
