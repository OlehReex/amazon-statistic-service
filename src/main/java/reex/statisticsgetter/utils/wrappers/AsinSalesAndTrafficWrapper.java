package reex.statisticsgetter.utils.wrappers;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import reex.statisticsgetter.model.salesAndTrafficByAsin.AsinSalesAndTraffic;

@Getter
@Setter
public class AsinSalesAndTrafficWrapper {
    List<AsinSalesAndTraffic> salesAndTrafficByAsin;
}
