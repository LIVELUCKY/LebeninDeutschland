package com.livelucky.lebenindeutschland.domain.model

enum class Category(val txt: String, val state: Boolean = true) {
    GRUNDRECHTE("Grundrechte", false),
    VERFASSUNGSPRINZIPIEN("Verfassungsprinzipien", false),
    WAHLEN_UND_BETEILIGUNG("Wahlen und Beteiligung", false),
    VERFASSUNGSORGANE("Verfassungsorgane", false),
    STAATSSYMBOLE("Staatssymbole", false),
    SOZIALSYSTEM("Sozialsystem", false),
    FOEDERALISMUS("Föderalismus", false),
    RELIGIOESE_VIELFALT("Religiöse Vielfalt", false),
    AUFGABEN_DES_STAATES("Aufgaben des Staates", false),
    WICHTIGE_STATIONEN_NACH_1945("Wichtige Stationen nach 1945", false),
    KOMMUNE("Kommune", false),
    PARTEIEN("Parteien", false),
    PFLICHTEN("Pflichten", false),
    RECHT_UND_ALLTAG("Recht und Alltag", false),
    DER_NATIONALSOZIALISMUS_UND_SEINE_FOLGEN("Der Nationalsozialismus und seine Folgen", false),
    DEUTSCHLAND_UND_EUROPA("Deutschland und Europa", false),
    WIEDERVEREINIGUNG("Wiedervereinigung", false),
    DEUTSCHLAND_IN_EUROPA("Deutschland in Europa", false),
    BILDUNG("Bildung", false),
    INTERKULTURELLES_ZUSAMMENLEBEN("Interkulturelles Zusammenleben", false),
    MIGRATIONSGESCHICHTE("Migrationsgeschichte", false),
    BADEN_WUERTTEMBERG("Baden-Württemberg"),
    BAYERN("Bayern"),
    BERLIN("Berlin"),
    BRANDENBURG("Brandenburg"),
    BREMEN("Bremen"),
    HAMBURG("Hamburg"),
    HESSEN("Hessen"),
    MECKLENBURG_VORPOMMERN("Mecklenburg-Vorpommern"),
    NIEDERSACHSEN("Niedersachsen"),
    NORDRHEIN_WESTFALEN("Nordrhein-Westfalen"),
    RHEINLAND_PFALZ("Rheinland-Pfalz"),
    SAARLAND("Saarland"),
    SACHSEN("Sachsen"),
    SACHSEN_ANHALT("Sachsen-Anhalt"),
    SCHLESWIG_HOLSTEIN("Schleswig-Holstein"),
    THUERINGEN("Thüringen");

    companion object {
        fun from(search: String): Category =
            requireNotNull(values().find { it.txt == search }) { "No Category with txt $search" }

        fun states(): List<Category> = values().filter { category: Category -> category.state }
        fun nonStates(): List<Category> = values().filter { category: Category -> !category.state }
    }
}