package com.example.dukki

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_select.*

// 로그인 후 4개의 카테고리 중에 선택하는 액티비티
class SelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        val id = intent.getStringExtra("id")

        //각 버튼을 누르면 해당 액티비티로 이동을 한다

        menuBtn.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


        scoreBtn.setOnClickListener{
            val intent1 = Intent(this, RatingActivity::class.java)
            intent1.putExtra("id", id)
            startActivity(intent1)
        }


        communityBtn.setOnClickListener{
            val intent = Intent(this, CommunityActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }


    }

}