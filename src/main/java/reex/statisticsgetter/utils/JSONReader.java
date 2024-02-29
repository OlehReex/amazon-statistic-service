package reex.statisticsgetter.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reex.statisticsgetter.exception.JSONReaderException;
import reex.statisticsgetter.model.reportSpecification.ReportSpecification;
import reex.statisticsgetter.model.salesAndTrafficByAsin.AsinSalesAndTraffic;
import reex.statisticsgetter.model.salesAndTrafficByDate.DailySalesAndTraffic;
import reex.statisticsgetter.utils.wrappers.AsinSalesAndTrafficWrapper;
import reex.statisticsgetter.utils.wrappers.SalesAndTrafficWrapper;

@Getter
@Setter
@Component
public class JSONReader {
    private @Value("${custom.file.path}") String filePath;
    private ReportSpecification reportSpecification;
    private List<DailySalesAndTraffic> salesAndTrafficList;
    private List<AsinSalesAndTraffic> asinSalesAndTrafficList;
    private SalesAndTrafficWrapper salesAndTrafficWrapper;
    private AsinSalesAndTrafficWrapper asinSalesAndTrafficWrapper;

    public void readDataFromJSON() {
        try {
            Gson gson = new Gson();
            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));

            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonObject reportSpecificationJson = jsonObject.getAsJsonObject("reportSpecification");

            reportSpecification = gson.fromJson(reportSpecificationJson, ReportSpecification.class);

            salesAndTrafficWrapper = gson.fromJson(jsonString, SalesAndTrafficWrapper.class);
            salesAndTrafficList = salesAndTrafficWrapper.getSalesAndTrafficByDate();

            asinSalesAndTrafficWrapper = gson.fromJson(jsonString, AsinSalesAndTrafficWrapper.class);
            asinSalesAndTrafficList = asinSalesAndTrafficWrapper.getSalesAndTrafficByAsin();

        } catch (IOException e) {
            throw new JSONReaderException("Unable to read data from file");
        }
    }
}
