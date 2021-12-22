package com.adonizio.honorsmobileapps.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.adonizio.honorsmobileapps.quiz.databinding.ActivityMainBinding
const val KEY_INDEX = "index_of_question_key"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    data class Question(val id:Int, val answer:Boolean)
    val questions = listOf(Question(R.string.question1,true),Question(R.string.question2,false),Question(R.string.question3,true),Question(R.string.question4,true), Question(R.string.question5,false))
    var indexOfQuestion = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        if(savedInstanceState!=null){
            indexOfQuestion = savedInstanceState.getInt(KEY_INDEX)
        }
        updateQuestionText()
        binding.trueButton.setOnClickListener{
            checkAnswer(true)
        }
        binding.FalseButton.setOnClickListener{
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener{
            nextQuestion()
        }
        binding.QuestionTextView.setOnClickListener{
            nextQuestion()
        }
        binding.back.setOnClickListener{
            previousQuestion()
        }
    }
    override fun onSaveInstanceState(savedInstanceState: Bundle){
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(KEY_INDEX, indexOfQuestion)
    }
    fun nextQuestion(){
        indexOfQuestion+=1
        indexOfQuestion = indexOfQuestion% questions.size
        updateQuestionText()
    }
    fun previousQuestion(){
        if(indexOfQuestion-1>=0) {
            indexOfQuestion = indexOfQuestion - 1
        }
        else{
            indexOfQuestion = questions.size-1
        }
        updateQuestionText()
    }
    fun updateQuestionText() {
        binding.QuestionTextView.text = getString(questions.get(indexOfQuestion).id)
    }
    fun checkAnswer(answer:Boolean) {
        if (questions.get(indexOfQuestion).answer == answer) {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.toast_message2, Toast.LENGTH_SHORT).show()
        }
    }
}