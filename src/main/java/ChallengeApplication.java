import com.zendesk.challenge.config.ChallengeConfig;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * SpringBootApplication.
 *
 */
@Import(ChallengeConfig.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.zendesk.challenge"})
@SpringBootApplication
public class ChallengeApplication {

    private static Logger logger = LoggerFactory.getLogger(ChallengeApplication.class);

    public static void main(String[] args) {
        logger.info("STARTING ZENDESK APPLICATION");
        SpringApplication.run(ChallengeApplication.class, args);
        logger.info("ZENDESK APPLICATION STARTED");
    }

//    @Bean
//    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
//        return hemf.getSessionFactory();
//    }

}
