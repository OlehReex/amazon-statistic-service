package reex.statisticsgetter.model.salesAndTrafficByAsin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "sales_and_traffic_by_asin")
public class AsinSalesAndTraffic {
    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;
}
