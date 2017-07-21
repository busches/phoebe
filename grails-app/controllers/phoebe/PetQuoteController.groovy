package phoebe

import grails.converters.JSON
import petquote.*

class PetQuoteController {

    RateEngineService rateEngineService

    def quotecarts(PetQuoteCartRequest petQuoteCartRequest) {

        println petQuoteCartRequest.validate()
        println petQuoteCartRequest.getErrors()

        PetQuoteCartData quoteCartData = new PetQuoteCartData()
        quoteCartData.quoteCartId = UUID.randomUUID()
        quoteCartData.bindURL = "TBD"
        quoteCartData.warningMessage = ""
        quoteCartData.quotes = []
        petQuoteCartRequest.quotes.each {

            PetQuoteData quoteData = new PetQuoteData()
            quoteData.processResult = new ProcessResult(success: true, errorCode: "", errorMessage: "")
            quoteData.quoteId = UUID.randomUUID()
            quoteData.productCode = ProductCode.POIA25090
            quoteData.petName = it.petQuoteRequest.petName
            quoteData.quoteRelatedMessage = ""
            quoteData.fees = []

            Float rate = rateEngineService.ratePet(it.petQuoteRequest, petQuoteCartRequest.leadZipcode)
            quoteData.annualAmount = rate
            quoteData.monthlyAmount = rate / 12

            quoteCartData.quotes << quoteData
        }


        PetQuoteResponse petQuoteResponse = new PetQuoteResponse()
        petQuoteResponse.data = quoteCartData

        // println(petQuoteCartRequest as JSON)

        render petQuoteResponse as JSON
    }
}
