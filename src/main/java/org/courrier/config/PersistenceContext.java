package org.courrier.config;

import org.courrier.auditing.AuditingDateTimeProvider;
import org.courrier.auditing.CurrentTimeDateTimeService;
import org.courrier.auditing.DateTimeService;
import org.courrier.auditing.UsernameAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by SimonPascal on 04/16/2016.
 */
@Configuration
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@EnableJpaRepositories(basePackages = {
        "org.courrier.repositories"
})
@EnableTransactionManagement
public class PersistenceContext {

    @Bean
    AuditorAware<String> auditorProvider() {
        return new UsernameAuditorAware();
    }

    @Bean
    DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
        return new AuditingDateTimeProvider(dateTimeService);
    }

    //@Profile(Profiles.APPLICATION)
    @Bean
    DateTimeService currentTimeDateTimeService() {
        return new CurrentTimeDateTimeService();
    }
}
