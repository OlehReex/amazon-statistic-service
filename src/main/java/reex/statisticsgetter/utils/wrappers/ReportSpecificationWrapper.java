package reex.statisticsgetter.utils.wrappers;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import reex.statisticsgetter.model.reportSpecification.ReportSpecification;

@Getter
@Setter
public class ReportSpecificationWrapper {
    private List<ReportSpecification> reportSpecificationList;
}
