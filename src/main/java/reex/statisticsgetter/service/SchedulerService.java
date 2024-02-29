package reex.statisticsgetter.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reex.statisticsgetter.exception.SchedulerException;
import reex.statisticsgetter.utils.JSONReader;

@RequiredArgsConstructor
@Setter
@Service
public class SchedulerService {
    private final JSONReader jsonReader;
    private final UpdateDataService updateDataService;
    private @Value("${custom.file.path}") String filePath;
    private long lastModifiedTime;

    public void schedulerUpdateChecker() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            try {
                long currentModifiedTime = Files.getLastModifiedTime(Paths.get(filePath)).toMillis();

                if (currentModifiedTime > lastModifiedTime) {
                    System.out.println("File has been updated.");
                    jsonReader.readDataFromJSON();
                    updateDataService.updateData();
                    lastModifiedTime = currentModifiedTime;
                } else {
                    System.out.println("File has not been updated.");
                }
            } catch (Exception e) {
                throw new SchedulerException("Unable to check/update data");
            }
        }, 0, 5, TimeUnit.MINUTES);
//        executor.schedule(() -> executor.shutdown(), 1, TimeUnit.HOURS);
    }
}
