package com.beerfind.beerfind.Components

import com.beerfind.beerfind.Data.BeerData
import com.intellij.ui.table.JBTable
import javax.swing.table.DefaultTableModel

class InfoTable(url: String): JBTable() {
    private var beers = BeerData().GetResponse(url)
    init {
        val model = DefaultTableModel()
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