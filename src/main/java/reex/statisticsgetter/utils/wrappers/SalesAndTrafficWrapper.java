package reex.statisticsgetter.utils.wrappers;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import reex.statisticsgetter.model.salesAndTrafficByDate.DailySalesAndTraffic;

@Getter
@Setter
public class SalesAndTrafficWrapper {
	private List<DailySalesAndTraffic> salesAndTrafficByDate;

}