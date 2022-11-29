package com.beerfind.beerfind.DialogWrappers

import com.beerfind.beerfind.Components.InfoTable
import com.beerfind.beerfind.Components.ZodiacComboBox
import com.beerfind.beerfind.Data.BeerData
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.components.JBLabel
import com.intellij.uiDesigner.core.AbstractLayout
import com.intellij.util.ui.GridBag
import com.intellij.util.ui.JBUI
import com.intellij.util.ui.UIUtil
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.JComponent
import javax.swing.JPanel

class RandomBeerWrapper: DialogWrapper(true) {
    private val gb = GridBag()
        .setDefaultInsets(Insets(0, 0, AbstractLayout.DEFAULT_VGAP, AbstractLayout.DEFAULT_HGAP))
        .setDefaultWeightX(1.0)
        .setDefaultFill(GridBagConstraints.HORIZONTAL)
    private val panel = JPanel(GridBagLayout())
    private val url = BeerData().urlRand
    private var isOk = false
    private val zodiacs = listOf(
        "Aries",
        "Taurus",
        "Gemini",
        "Cancer",
        "Leo",
        "Virgo",
        "Libra",
        "Scorpio",
        "Sagittarius",
        "Capricorn",
        "Aquarius",
        "Pisces"
    )
    init {
        init()
        title = "Beer Horoscope"
    }
    override fun createCenterPanel(): JComponent {
        panel.preferredSize = Dimension(400, 200)
        panel.add(label("Zodiac"), gb.nextLine().next())
        panel.add(ZodiacComboBox(zodiacs), gb.nextLine().next())
        return panel
    }

    override fun doOKAction() {
        panel.updateUI()
        panel.removeAll()
        if (!isOk) {
            panel.setSize(1200, 600)
            panel.add(InfoTable(url, true), gb.nextLine().next())
            isOk = true
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