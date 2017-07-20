package petquote

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class PetQuoteCartRequest {
    // pattern: "[a-zA-Z0-9\\s]{1,60}"
    @NotNull
    @Size(min = 1, max = 60)
    String leadFirstName

    // pattern: "[a-zA-Z0-9\\s]{1,60}"
    @NotNull
    @Size(min = 1, max = 60)
    String leadLastName

    @NotNull
    @Size(min = 1, max = 60)
    String leadEmail

    @NotNull
    @Size(max = 60)
    String leadZipcode

    // pattern: '[a-zA-Z0-9]{1,6}'
    @Size(max = 6)
    String originCode

    // pattern: "[0-9\\-]*"
    String leadPhone

    List<PetQuoteRequest> quotes
}
