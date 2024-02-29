package reex.statisticsgetter.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reex.statisticsgetter.dto.BetweenDatesRequestDto;
import reex.statisticsgetter.dto.ByAsinsRequestDto;
import reex.statisticsgetter.dto.ByDateRequestDto;
import reex.statisticsgetter.model.salesAndTrafficByAsin.AsinSalesAndTraffic;
import reex.statisticsgetter.model.salesAndTrafficByDate.DailySalesAndTraffic;
import reex.statisticsgetter.service.StatisticService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/stat")
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/between-dates")
    public List<DailySalesAndTraffic> getStatBetweenDates(@RequestBody BetweenDatesRequestDto betweenDatesRequestDto) {
        return statisticService.findByDateBetween(betweenDatesRequestDto);
    }

    @GetMapping("/by-date")
    public DailySalesAndTraffic getStatByDate(@RequestBody ByDateRequestDto byDateRequestDto) {
        return statisticService.findByDate(byDateRequestDto);
    }

    @GetMapping("/all-by-date")
    public List<DailySalesAndTraffic> getFullStatByDate() {
        return statisticService.findAllByDate();
    }

    @GetMapping("/by-asins")
    public List<AsinSalesAndTraffic> getStatByAsins(@RequestBody ByAsinsRequestDto byAsinsRequestDto) {
        return statisticService.findByAsinsList(byAsinsRequestDto);
    }

    @GetMapping("/all-by-asins")
    public List<AsinSalesAndTraffic> getFullStatByAsins() {
        return statisticService.findAllByAsin();
    }
}
