package phoebe

class HomeController {
    StatsService statsService

    def index() {
        statsService.getStats('29900')
        render view: 'index'
    }
}
