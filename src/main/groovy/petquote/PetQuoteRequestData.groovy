package petquote

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class PetQuoteRequestData {

    // pattern: "[a-zA-Z\\s]{1,50}"
    @NotNull
    @Size(max = 50)
    String petName

    @NotNull
    PetSpecies petSpecies

    @NotNull
    String petBreedId

    @NotNull
    //description: YYYY - MM - DD
    Date petDateOfBirth

    @NotNull
    ProductCode productCode

    @NotNull
    String apiKey

    Gender gender

    String petColorId
}
