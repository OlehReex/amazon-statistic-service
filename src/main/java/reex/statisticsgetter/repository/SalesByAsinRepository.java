package reex.statisticsgetter.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import reex.statisticsgetter.model.salesAndTrafficByAsin.AsinSalesAndTraffic;

@Repository
public interface SalesByAsinRepository extends MongoRepository<AsinSalesAndTraffic, String> {

    List<AsinSalesAndTraffic> findByParentAsinIn(List<String> parentAsins);

    List<AsinSalesAndTraffic> findAll();

}
