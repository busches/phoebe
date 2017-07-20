package phoebe

class QuoteBind {
    String agentNumber
    Date quoteDate
    Date bindDate
    Double commission

    static constraints = {
        bindDate nullable: true
    }
}
