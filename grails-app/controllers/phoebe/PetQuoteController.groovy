package phoebe

import grails.converters.JSON
import petquote.PetQuoteCartData
import petquote.PetQuoteCartRequest
import petquote.PetQuoteData
import petquote.PetQuoteResponse
import petquote.ProcessResult
import petquote.ProductCode

class PetQuoteController {

    RateEngineService rateEngineService

    def quotecarts(PetQuoteCartRequest petQuoteCartRequest) {

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

            Float rate = rateEngineService.ratePet(it, petQuoteCartRequest.leadZipcode)

            quoteCartData.quotes << quoteData
        }


        PetQuoteResponse petQuoteResponse = new PetQuoteResponse()
        petQuoteResponse.data = quoteCartData

        println(petQuoteCartRequest as JSON)

        render petQuoteResponse as JSON
    }
}
