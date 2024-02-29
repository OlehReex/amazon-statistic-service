package reex.statisticsgetter.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reex.statisticsgetter.model.salesAndTrafficByDate.DailySalesAndTraffic;

@Repository
public interface SalesByDateRepository extends MongoRepository<DailySalesAndTraffic, String> {
    @Query("{'date': {$gte: ?0, $lte: ?1}}")
    List<DailySalesAndTraffic> findByDateBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);

    DailySalesAndTraffic findByDate(String date);
}
