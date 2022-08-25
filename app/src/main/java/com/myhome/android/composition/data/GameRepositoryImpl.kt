package com.myhome.android.composition.data

import com.myhome.android.composition.domain.entity.GameSettings
import com.myhome.android.composition.domain.entity.Level
import com.myhome.android.composition.domain.entity.Question
import com.myhome.android.composition.domain.repository.GameRepository
import java.lang.Integer.max
import java.lang.StrictMath.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    60,
                    10
                )
            }
            Level.EASY -> {
                GameSettings(
                    20,
                    5,
                    60,
                    30
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    50,
                    10,
                    80,
                    30
                )
            }
            Level.HARD -> {
                GameSettings(
                    100,
                    20,
                    90,
                    30
                )
            }
        }
    }

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size != countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }
}