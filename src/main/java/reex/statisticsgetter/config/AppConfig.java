package reex.statisticsgetter.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import reex.statisticsgetter.service.SchedulerService;

@Configuration
public class AppConfig {

    private final SchedulerService schedulerService;

    @Autowired
    public AppConfig(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @PostConstruct
    public void init() {
        schedulerService.schedulerUpdateChecker();
    }
}