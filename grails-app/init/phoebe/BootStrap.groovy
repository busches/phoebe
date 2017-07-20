package phoebe

class BootStrap {

    def init = { servletContext ->
        100.times {
            def bindDate = (Math.random() < 0.5) ? (new Date() - it) : null
            new QuoteBind(agentNumber: '29900', commission: Math.random()*100 + 1, quoteDate: new Date() - it, bindDate: bindDate).save()
        }
    }
    def destroy = {
    }
}
