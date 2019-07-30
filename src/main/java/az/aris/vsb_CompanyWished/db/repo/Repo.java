package az.aris.vsb_CompanyWished.db.repo;

import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface Repo extends JpaRepository<CompanyWished,Long> {

    CompanyWished findByIdCompanyWished(long idCompanyWished);

    List<CompanyWished> findByIdCompany(long idCompany);

    List<CompanyWished> findByIdDriver(long idDriver);

    List<CompanyWished> findByRequestDate(Date requestDate);
}
