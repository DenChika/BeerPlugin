package com.beerfind.beerfind.Actions

import com.beerfind.beerfind.DialogWrappers.BeerDialogWrapper
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class FindAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val wrap = BeerDialogWrapper()
        wrap.show()
    }

}