package petquote

import groovy.time.TimeCategory
import spock.lang.Specification
import spock.lang.Unroll

class PetQuoteRequestDataTest extends Specification {
    @Unroll
    def "GetAge"() {
        when:
        def petDateOfBirth
        use(TimeCategory) {
            petDateOfBirth = new Date()
            petDateOfBirth = petDateOfBirth - years * 365 - months * 30 as Date
            println petDateOfBirth
        }
        def pets = new PetQuoteRequestData(petDateOfBirth: petDateOfBirth)

        then:
        pets.getAge() == age

        where:
        years | months | age
        0     | 0      | 0
        1     | 0      | 1
        1     | 1      | 1
        0     | 11     | 0
        12    | 11     | 12

    }
}
