package reex.statisticsgetter.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reex.statisticsgetter.dto.BetweenDatesRequestDto;
import reex.statisticsgetter.dto.ByAsinsRequestDto;
import reex.statisticsgetter.dto.ByDateRequestDto;
import reex.statisticsgetter.model.salesAndTrafficByAsin.AsinSalesAndTraffic;
import reex.statisticsgetter.model.salesAndTrafficByDate.DailySalesAndTraffic;
import reex.statisticsgetter.repository.SalesByAsinRepository;
import reex.statisticsgetter.repository.SalesByDateRepository;

@CacheConfig(cacheNames = "SalesAndTraffic")
@RequiredArgsConstructor
@Service
public class StatisticService {
    private final SalesByDateRepository salesByDateRepository;
    private final SalesByAsinRepository salesByAsinRepository;

    @Cacheable
    public List<DailySalesAndTraffic> findByDateBetween(BetweenDatesRequestDto betweenDatesRequestDto) {
        return salesByDateRepository.findByDateBetween(
                betweenDatesRequestDto.startDate(), betweenDatesRequestDto.endDate());
    }

    @Cacheable
    public DailySalesAndTraffic findByDate(ByDateRequestDto byDateRequestDto) {
        return salesByDateRepository.findByDate(byDateRequestDto.date());
    }

    @Cacheable
    public List<DailySalesAndTraffic> findAllByDate() {
        return salesByDateRepository.findAll();
    }

    @Cacheable
    public List<AsinSalesAndTraffic> findByAsinsList(ByAsinsRequestDto byAsinsRequestDto) {
        return salesByAsinRepository.findByParentAsinIn(byAsinsRequestDto.asinsList());
    }

    @Cacheable
    public List<AsinSalesAndTraffic> findAllByAsin() {
        return salesByAsinRepository.findAll();
    }
}
