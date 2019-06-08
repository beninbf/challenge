import com.zendesk.challenge.config.ChallengeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 *
 * <code>ChallengeApplication</code> spring boot application.
 * <pre>
 * <strong>History</strong>    Name              Date            Description
 * <strong>History</strong>    --------------------------------------------------------------------
 * <strong>History</strong>    Benin Bryant      June 6, 2019    Creating a basic search.
 * </pre>
 *
 * @author Benin Bryant
 * @since June 6, 2019
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
}
