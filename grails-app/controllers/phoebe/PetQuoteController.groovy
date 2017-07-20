package phoebe

import grails.converters.JSON
import petquote.PetQuoteCartData
import petquote.PetQuoteCartRequest
import petquote.PetQuoteResponse

class PetQuoteController {

    def quotecarts(PetQuoteCartRequest petQuoteCartRequest) {

        PetQuoteResponse petQuoteResponse = new PetQuoteResponse()
        PetQuoteCartData quoteCartData = new PetQuoteCartData()
        petQuoteResponse.data = quoteCartData

        println(petQuoteCartRequest as JSON)

        render petQuoteResponse as JSON
    }
}
