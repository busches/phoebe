package phoebe

import grails.transaction.Transactional
import petquote.PetQuoteRequestData
import petquote.PetSpecies

@Transactional
class RateEngineService {

    def ratePet(PetQuoteRequestData petData) {
        def baseRate = 713.24
        def deductibleFactor = 1
        def coInsuranceFactor = 1
        def speciesFactor = 1
        def ageFactor = determineAgeFactor(petData.age, petData.petSpecies)
        def breedFactor = 1

        return baseRate * deductibleFactor * coInsuranceFactor * speciesFactor * ageFactor * breedFactor
    }

    def determineAgeFactor(int age, PetSpecies petSpecies) {
        def ageFactor = [
                Cat: [0: 1.00, 1: 1.00, 2: 1.00, 3: 1.08, 4: 1.17, 5: 1.29, 6: 1.43, 7: 1.58, 8: 1.76, 9: 1.95, 10: 2.17, 11: 2.40, 12: 2.68, 13: 2.97, 14: 3.25, 15: 3.48, 16: 3.57, 17: 3.66, 18: 3.76, 19: 3.85, default: 3.95],
                Dog: [0: 1.00, 1: 1.00, 2: 1.00, 3: 1.09, 4: 1.23, 5: 1.38, 6: 1.55, 7: 1.71, 8: 1.90, 9: 2.15, 10: 2.43, 11: 2.73, 12: 3.05, 13: 3.29, 14: 3.53, 15: 3.81, 16: 4.12, 17: 4.47, 18: 4.88, 19: 5.35, default: 5.50]
        ]
        ageFactor[petSpecies as String].hasProperty(age as String) ? ageFactor[petSpecies as String][age] : ageFactor[petSpecies as String].default
    }
}
