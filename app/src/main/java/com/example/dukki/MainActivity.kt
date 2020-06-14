package com.example.dukki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

// 메인 화면 Activity
class MainActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 로그인 버튼 클릭 시
        loginBtn.setOnClickListener{
            //로그인 view 추가 예정
        }

        // 회원가입 버튼 클릭 시
        joinBtn.setOnClickListener{
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

        // Preference에 저장된 사용자 id 불러오기
        val prefs = getSharedPreferences("user", 0)
        val id : String = prefs.getString("id","").toString()


    }

}