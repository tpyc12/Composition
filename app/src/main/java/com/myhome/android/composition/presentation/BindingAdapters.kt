package com.myhome.android.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.myhome.android.composition.R
import com.myhome.android.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswer")
fun bindRequiredAnswer(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.min_count_of_right_answers),
        count
    )
}

@BindingAdapter("count")
fun bindCountOfRightAnswers(textView: TextView, count: Int){
    textView.text = String.format(
        textView.context.getString(R.string.count_of_right_answers),
        count
    )
}

@BindingAdapter("requiredPercent")
fun bindRequiredPercent(textView: TextView, count: Int){
    textView.text = String.format(
        textView.context.getString(R.string.min_percentage_of_right_answers),
        count
    )
}

@BindingAdapter("emoji")
fun bindEmoji(imageView: ImageView, imageRes: Boolean){
    val image = if (imageRes) {
        R.drawable.ic_baseline_mood_24
    } else {
        R.drawable.ic_baseline_mood_bad_24
    }
    imageView.setImageResource(image)
}

@BindingAdapter("percent")
fun bindPercent(textView: TextView, gameResult: GameResult){
    textView.text = String.format(
        textView.context.getString(R.string.percentage_of_right_answers),
        getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    }
    ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
}