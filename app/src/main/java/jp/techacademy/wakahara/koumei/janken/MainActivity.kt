package jp.techacademy.wakahara.koumei.janken

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gu.setOnClickListener { onJankenButtonTapped(it)}
        choki.setOnClickListener { onJankenButtonTapped(it)}
        pa.setOnClickListener { onJankenButtonTapped(it)}

        //アプリ起動時に共有プリファレンスをクリアする
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear().apply()
    }
    // 画面遷移
    fun onJankenButtonTapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("MY_HAND", view?.id)
        startActivity(intent)
/*     Anko を使った場合の画面遷移
    fun onJankenButtonTapped(view: View?) {
        startActivity<ResultActivity>("MY_HAND" to view?.id)
*/
    }
}
