package com.beerfind.beerfind.DialogWrappers

import com.beerfind.beerfind.Components.InfoTable
import com.beerfind.beerfind.Data.BeerData
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBLabel
import com.intellij.uiDesigner.core.AbstractLayout
import com.intellij.util.ui.*
import java.awt.*
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField

class BeerDialogWrapper: DialogWrapper(true) {

    private var url: String = BeerData().urlIncreasedPageSize
    private val gb = GridBag()
        .setDefaultInsets(Insets(0, 0, AbstractLayout.DEFAULT_VGAP, AbstractLayout.DEFAULT_HGAP))
        .setDefaultWeightX(1.0)
        .setDefaultFill(GridBagConstraints.HORIZONTAL)
    private var isOk = false
    private val panel = JPanel(GridBagLayout())
    private val abvGt = JTextField()
    private val abvLt = JTextField()
    private val ibuGt = JTextField()
    private val ibuLt = JTextField()
    private val ebcGt = JTextField()
    private val ebcLt = JTextField()
    private val beerName = JTextField()
    private val yeastName = JTextField()
    private val brewedBefore = JTextField()
    private val brewedAfter = JTextField()
    private val hops = JTextField()
    private val malt = JTextField()
    private val food = JTextField()
    private val requestParams = mapOf(
        "abv_gt" to abvGt,
        "abv_lt" to abvLt,
        "ibu_gt" to ibuGt,
        "ibu_lt" to ibuLt,
        "ebc_gt" to ebcGt,
        "ebc_lt" to ebcLt,
        "beer_name" to beerName,
        "yeast" to yeastName,
        "brewed_before" to brewedAfter,
        "brewed_after" to brewedBefore,
        "hops" to hops,
        "malt" to malt,
        "food_pairing" to food
    )
    private val textField = mapOf(
         abvGt to "ABV greater than",
         abvLt to "ABV less than",
         ibuGt to "IBU greater than",
         ibuLt to "IBU less than",
         ebcGt to "EBC greater than",
         ebcLt to "EBC less than",
         beerName to "Beer name",
         yeastName to "Yeast name",
         brewedBefore to "Brewed before",
         brewedAfter to "Brewed after",
         hops to "Hops",
         malt to "Malt",
         food to "Food pairing"
    )

    init {
        init()
        title = "Beer Find"
    }
    override fun createCenterPanel(): JComponent {
        panel.preferredSize = Dimension(1200, 600)
        for(pair in requestParams) {
            textField[pair.value]?.let { addToPanel(it, pair.value, gb) }
        }

        return panel
    }
    override fun doOKAction() {
        panel.updateUI()
        panel.removeAll()
        if (!isOk) {
            for(pair in requestParams) {
                addToUrl(pair.key, pair.value)
            }
            panel.add(InfoTable(url), gb.nextLine().next())
            isOk = true
        }
    }
    private fun addToPanel(text: String, textField: JTextField, gb: GridBag) {
        panel.add(label(text), gb.nextLine().next())
        panel.add(textField, gb.nextLine().next())
    }
    private fun addToUrl(request: String, textField: JTextField) {
        if (textField.text.isNotEmpty()) {
            url += "&$request=${textField.text}"
        }
    }
    private fun label(text: String): JComponent {
        val label = JBLabel(text)
        label.componentStyle = UIUtil.ComponentStyle.SMALL
        label.fontColor = UIUtil.FontColor.NORMAL
        label.border = JBUI.Borders.empty(0, 2, 0, 0)
        return label
    }
}