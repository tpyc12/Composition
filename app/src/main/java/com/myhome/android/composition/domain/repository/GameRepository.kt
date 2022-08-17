package com.myhome.android.composition.domain.repository

import com.myhome.android.composition.domain.entity.GameSettings
import com.myhome.android.composition.domain.entity.Level
import com.myhome.android.composition.domain.entity.Question

interface GameRepository {

    fun getGameSettings(level: Level): GameSettings

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question
}