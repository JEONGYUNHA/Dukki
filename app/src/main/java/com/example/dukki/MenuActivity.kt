package com.example.dukki

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

// 메뉴 data를 나타내는 class
data class Menu(var img: String, var name: String, var price: Int)

// 학식 메뉴 띄우는 Activity
// 카테고리별 Fragment 만들어 총 3개의 카테고리를 Tab Layout으로 표현
class MenuActivity  : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)



    }


}