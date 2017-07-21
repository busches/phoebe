package phoebe

import grails.transaction.Transactional
import petquote.PetQuoteRequestData
import petquote.PetSpecies

@Transactional
class RateEngineService {

    Float ratePet(PetQuoteRequestData petData, String zipCode) {
        def baseRate = 873
        def deductibleFactor = 0.85 // Assume $250
        def coInsuranceFactor = 1 // Assume 90%
        def speciesFactor = determineSpeciesFactor(petData.petSpecies)
        def ageFactor = determineAgeFactor(petData.age, petData.petSpecies)
        def breedFactor = determineBreedFactor(petData.petBreedId)
        def stateFactor = determineStateFactor(zipCode)

        return baseRate * deductibleFactor * coInsuranceFactor * speciesFactor * ageFactor * breedFactor * stateFactor
    }

    def determineStateFactor(String zipCode) {
        def stateFactor = [ALABAMA: 0.80, ALASKA: 0.75, ARIZONA: 0.90, ARKANSAS: 0.80, CALIFORNIA: 0.95, COLORADO: 0.95, CONNECTICUT: 1.15, DELAWARE: 1.00, 'DISTRICT OF COLUMBIA': 1.20, FLORIDA: 1.00, GEORGIA: 0.90, HAWAII: 1.00, IDAHO: 0.85, ILLINOIS: 1.10, INDIANA: 0.85, IOWA: 0.95, KANSAS: 0.75, KENTUCKY: 0.85, LOUISIANA: 0.95, MAINE: 1.00, MARYLAND: 1.05, MASSACHUSETTS: 1.10, MICHIGAN: 0.90, MINNESOTA: 1.00, MISSISSIPPI: 0.80, MISSOURI: 0.75, MONTANA: 0.95, NEBRASKA: 0.85, NEVADA: 0.80, 'NEW HAMPSHIRE': 1.00, 'NEW JERSEY': 1.10, 'NEW MEXICO': 0.80, 'NEW YORK': 1.15, 'NORTH CAROLINA': 1.05, 'NORTH DAKOTA': 0.95, OHIO: 0.95, OKLAHOMA: 0.80, OREGON: 1.05, PENNSYLVANIA: 1.00, 'RHODE ISLAND': 0.95, 'SOUTH CAROLINA': 0.95, 'SOUTH DAKOTA': 0.90, TENNESSEE: 0.95, TEXAS: 0.95, UTAH: 0.80, VERMONT: 1.05, VIRGINIA: 1.05, WASHINGTON: 0.90, 'WEST VIRGINIA': 0.85, WISCONSIN: 1.05, WYOMING: 0.85]
        def state = StateLookupService.getStateFromZipCode(zipCode)
        stateFactor[state]
    }

    def determineBreedFactor(String petBreed) {
        def breedFactor = [A: 1.00, B: 1.15, C: 1.37, D: 1.80, X1: 0.98, X2: 1.12, A2: 1.00, B2: 1.10]
        breedFactor[petBreed]
    }

    def determineSpeciesFactor(PetSpecies petSpecies) {
        def speciesFactor = [
                Cat: 0.60,
                Dog: 1.00
        ]
        speciesFactor[petSpecies as String]
    }

    def determineAgeFactor(int age, PetSpecies petSpecies) {
        def ageFactor = [
                Cat: [0: 1.00, 1: 1.00, 2: 1.00, 3: 1.08, 4: 1.17, 5: 1.29, 6: 1.43, 7: 1.58, 8: 1.76, 9: 1.95, 10: 2.17, 11: 2.40, 12: 2.68, 13: 2.97, 14: 3.25, 15: 3.48, 16: 3.57, 17: 3.66, 18: 3.76, 19: 3.85, default: 3.95],
                Dog: [0: 1.00, 1: 1.00, 2: 1.00, 3: 1.09, 4: 1.23, 5: 1.38, 6: 1.55, 7: 1.71, 8: 1.90, 9: 2.15, 10: 2.43, 11: 2.73, 12: 3.05, 13: 3.29, 14: 3.53, 15: 3.81, 16: 4.12, 17: 4.47, 18: 4.88, 19: 5.35, default: 5.50]
        ]
        ageFactor[petSpecies as String].hasProperty(age as String) ? ageFactor[petSpecies as String][age] : ageFactor[petSpecies as String].default
    }
}
