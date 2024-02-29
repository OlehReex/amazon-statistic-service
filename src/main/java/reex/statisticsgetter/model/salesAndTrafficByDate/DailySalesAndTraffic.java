package reex.statisticsgetter.model.salesAndTrafficByDate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "sales_and_traffic_by_date")
public class DailySalesAndTraffic {
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;
}
