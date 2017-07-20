package phoebe

class StateLookupService {

    static def stateZip = [:]

    StateLookupService() {
        this.class.getClassLoader().getResourceAsStream('us_postal_codes.csv').text.split('\r\n').each {
            def (zipCode, state) = it.tokenize(',')
            stateZip[zipCode] = state
        }
    }

    static String getStateFromZipCode(String zipCode) {
        stateZip[zipCode].toUpperCase()
    }
}
