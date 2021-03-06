package com.example.dukki
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rating.*

// selectActivity 에서 평점 버튼을 누르게 되면 보이는 액티비티
class RatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        val id = intent.getStringExtra("id")

        // 각 버튼을 누르면 각 기능에 맞는 액티비티 띄운다

        seeReview.setOnClickListener {
            val intent = Intent(this, SeeReviewActivity::class.java)
            startActivity(intent)
        }

        giveReview.setOnClickListener {
            val intent1 = Intent(this, GiveReviewActivity::class.java)

            intent1.putExtra("id", id)
            startActivity(intent1)
        }

    }

}