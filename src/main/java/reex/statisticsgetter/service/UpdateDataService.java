package reex.statisticsgetter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import reex.statisticsgetter.repository.SalesByAsinRepository;
import reex.statisticsgetter.repository.SalesByDateRepository;
import reex.statisticsgetter.utils.JSONReader;

@RequiredArgsConstructor
@Service
public class UpdateDataService {
    private final SalesByDateRepository salesByDateRepository;
    private final SalesByAsinRepository salesByAsinRepository;
    private final JSONReader jsonReader;

    @CacheEvict(cacheNames = {"SalesAndTraffic"}, allEntries = true)
    public void updateData() {
        salesByDateRepository.deleteAll();
        salesByDateRepository.saveAll(jsonReader.getSalesAndTrafficList());
        salesByAsinRepository.deleteAll();
        salesByAsinRepository.saveAll(jsonReader.getAsinSalesAndTrafficList());
    }
}
