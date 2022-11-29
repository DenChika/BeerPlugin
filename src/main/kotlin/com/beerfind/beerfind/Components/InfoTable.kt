package com.beerfind.beerfind.Components

import com.beerfind.beerfind.Data.Beer
import com.beerfind.beerfind.Data.BeerData
import com.intellij.ui.table.JBTable
import javax.swing.table.DefaultTableModel

class InfoTable(url: String, isRandom: Boolean): JBTable() {
    init {
        val model = DefaultTableModel()
        val beers: List<Beer> = if (!isRandom) {
            val beers1 = BeerData().GetResponse("$url&page=1")
            val beers2 = BeerData().GetResponse("$url&page=2")
            val beers3 = BeerData().GetResponse("$url&page=3")
            val beers4 = BeerData().GetResponse("$url&page=4")
            val beers5 = BeerData().GetResponse("$url&page=5")
            beers1 + beers2 + beers3 + beers4 + beers5
        } else
            BeerData().GetResponse(url)
        model.addColumn("Property")
        model.addColumn("Value")
        model.addRow(arrayOf("Name", beers[0].name))
        model.addRow(arrayOf("Description", beers[0].description))
        model.addRow(arrayOf("First brewed", beers[0].firstBrewed))
        model.addRow(arrayOf("ABV", beers[0].abv))
        model.addRow(arrayOf("IBU", beers[0].ibu))
        model.addRow(arrayOf("EBC", beers[0].ebc))
        model.addRow(arrayOf("SRM", beers[0].srm))
        model.isCellEditable(0, 0)
        var i = 1
        for (food in beers[0].food) {
            model.addRow(arrayOf("Food pairing $i", food))
            i++
        }
        model.addRow(arrayOf("Brewers tips", beers[0].brewersTips))
        this.model = model
    }
}