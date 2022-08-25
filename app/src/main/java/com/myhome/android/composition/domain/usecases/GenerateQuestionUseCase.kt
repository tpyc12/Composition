package com.myhome.android.composition.domain.usecases

import com.myhome.android.composition.domain.entity.Question
import com.myhome.android.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_ANSWERS)
    }

    private companion object {
        private const val COUNT_OF_ANSWERS = 6
    }
}