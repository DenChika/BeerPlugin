package com.beerfind.beerfind.Actions

import com.beerfind.beerfind.DialogWrappers.RandomBeerWrapper
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class HoroscopeAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val wrap = RandomBeerWrapper()
        wrap.show()
    }
}