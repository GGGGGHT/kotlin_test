class CountryApp {
  fun filterCountries(country: List<Country>) : List<Country> {
    val res = mutableListOf<Country>()
    for (c in country) {
      if (c.continient == "EU") {
        res.add(c)
      }
    }
    return res
  }

  fun filterCountries(countries: List<Country>,
    // add a function parameter
  test: (Country) -> Boolean) : List<Country> {
    val res = mutableListOf<Country>()
    for (c in countries) {
      if (test(c)) {
        res.add(c)
      }
    }
    return res
  }

  // method reference
}