package com.beerfind.beerfind.Components

import com.intellij.openapi.ui.ComboBox

class ZodiacComboBox(methods: List<String>) : ComboBox<String>(methods.toTypedArray()) {
    init {
        this.isEditable = false
        this.selectedItem = methods[0]
    }
}