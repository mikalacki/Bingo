package models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {

    private val _balls = MutableLiveData<ArrayList<String>>(arrayListOf())
    val balls = _balls

    fun addBall(ball: String) {
        _balls.value?.add(ball)
    }

    fun removeBall(ball: String) {
        _balls.value?.remove(ball)
    }

    fun removeBalls() {
        _balls.value = ArrayList()
    }

    fun ballSize(): Int? {
        return _balls.value?.size
    }

}