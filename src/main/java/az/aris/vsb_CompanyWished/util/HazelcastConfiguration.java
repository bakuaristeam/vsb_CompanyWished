package az.aris.vsb_CompanyWished.util;

import az.aris.vsb_CompanyWished.db.entity.CompanyWished;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.ISet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.List;

@Configuration
public class HazelcastConfiguration {

    @Bean
    public Config config() {
        return new Config();
    }

    @Bean
    public HazelcastInstance instance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    IMap<Long, CompanyWished> mapOfCompanyWished(HazelcastInstance instance) {
        return instance.getMap("mapOfCompanyWished");
    }

    @Bean
    public ISet<CompanyWished> setOfCompanyWished(HazelcastInstance instance) {
        return instance.getSet("setOfCompanyWished");
    }

    @Bean
    public IMap<Long, List<CompanyWished>> mapOfIdDriver(HazelcastInstance instance) {
        return instance.getMap("mapOfIdDriver");
    }

    @Bean
    public IMap<Long, List<CompanyWished>> mapOfIdCompany(HazelcastInstance instance) {
        return instance.getMap("mapOfIdCompany");
    }

    @Bean
    public IMap<Date, List<CompanyWished>> mapOfRequestDate(HazelcastInstance instance) {
        return instance.getMap("mapOfRequestDate");
    }

}