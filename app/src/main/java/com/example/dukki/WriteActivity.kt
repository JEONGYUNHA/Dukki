package com.example.dukki

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*

data class Board(var content: String, var id: String, var title:String, var count:Int = 0)

// 게시판에 글을 쓸 수 있는 액티비티
class WriteActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private val commuData = ArrayList<MyCommunity>()
    public var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        context = this
        val id = intent.getStringExtra("id")
        var num = 1

        //글쓰기 버튼을 누르면
        writeButton.setOnClickListener {

            var numString = num.toString()

            //board 컬렉션을 가져와서 count 필드로 정렬
            db.collection("board")
                .orderBy("count")
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val count = document.get("count").toString()
                        // 그 num이 이미 count 필드에 있다면 num++
                        if (num == Integer.parseInt(count)) {
                            num++
                        }
                    }

                    //글 쓴 제목과 내용을 가져온다
                    val writeTitle: String = writeTitle.text.toString()
                    val writeContent: String = writeContent.text.toString()

                    //board 컬렉션을 가져와서 numString을 document 이름으로 바꾸고 그 필드를 board 데이터 클래스로 넣어준다
                    numString = num.toString()
                    val board = Board(writeContent, id, writeTitle, num)
                    db.collection("board").document(numString).set(board)
                }

            finish()//신기해


        }
    }
}