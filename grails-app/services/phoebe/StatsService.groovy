package phoebe

import grails.transaction.Transactional
import petStat.MonthlyStat

@Transactional
class StatsService {

    Map<Integer, MonthlyStat> getStats(String agentNumber) {
        def model = [:]
        def quotes = QuoteBind.findAllByAgentNumber(agentNumber)
        def currentMonth = new Date().format('MM') as int
        3.times { numberOfMonthsInThePast ->
            def thisMonth = getMonthQuotes(quotes, currentMonth-numberOfMonthsInThePast)
            model."${numberOfMonthsInThePast}" = new MonthlyStat(quotes: thisMonth.size(), binds: thisMonth.count{it.bindDate != null}, money: thisMonth*.commission.sum())
        }
        return model
    }

    private List<QuoteBind> getMonthQuotes(List<QuoteBind> quotes, Integer monthNumber) {
        quotes.findAll{
            it.quoteDate.format('MM') as int == monthNumber
        }
    }
}
