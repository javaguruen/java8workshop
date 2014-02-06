package no.berghamre.data;

import java.util.ArrayList;
import java.util.List;

public class IncomeStatistics {
    public final String county;
    public final Gender sex;
    public final List<IncomeYear> incomeYears = new ArrayList<>();

    public IncomeStatistics(String county, Gender sex) {
        this.county = county;
        this.sex = sex;
    }
}
