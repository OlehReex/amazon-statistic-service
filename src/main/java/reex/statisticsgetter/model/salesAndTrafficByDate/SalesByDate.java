package reex.statisticsgetter.model.salesAndTrafficByDate;

import lombok.Getter;
import lombok.Setter;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.AverageSalesPerOrderItem;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.AverageSalesPerOrderItemB2B;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.AverageSellingPrice;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.AverageSellingPriceB2B;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.ClaimsAmount;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.OrderedProductSales;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.OrderedProductSalesB2B;
import reex.statisticsgetter.model.salesAndTrafficByDate.sales.ShippedProductSales;


@Getter
@Setter
class SalesByDate {
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private AverageSalesPerOrderItem averageSalesPerOrderItem;
    private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private AverageSellingPrice averageSellingPrice;
    private AverageSellingPriceB2B averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private ClaimsAmount claimsAmount;
    private ShippedProductSales shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;
}
