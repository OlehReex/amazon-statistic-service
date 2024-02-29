package reex.statisticsgetter.model.salesAndTrafficByAsin;

import lombok.Getter;
import lombok.Setter;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.OrderedProductSales;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.OrderedProductSalesB2B;

@Getter
@Setter
public class SalesByAsin {
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
}
