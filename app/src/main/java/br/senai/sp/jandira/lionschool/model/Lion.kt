package br.senai.sp.jandira.lionschool.model

import androidx.compose.ui.graphics.Color

data class Lion(
    var lion:Pair<String, Double>,
    var lionColor: Color,
    var lionStatus: LionStatus
)