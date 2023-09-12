package com.dicoding.valorantapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailRole: TextView = findViewById(R.id.tv_agent_role)
        val tvDetailOrigin: TextView = findViewById(R.id.tv_agent_origin)
        val tvDetailGender: TextView = findViewById(R.id.tv_agent_gender)
        val tvDetailBiography: TextView = findViewById(R.id.tv_agent_biography)

        // Mengambil data Agent yang dikirimkan melalui Intent
        val agentName = intent.getStringExtra("key_agent_name")
        val agentImageDetail = intent.getIntExtra("key_agent_image_detail", R.drawable.default_image)
        val agentRole = intent.getStringExtra("key_agent_role")
        val agentOrigin = intent.getStringExtra("key_agent_origin")
        val agentGender = intent.getStringExtra("key_agent_gender")
        val agentBiography = intent.getStringExtra("key_agent_biography")

        // Mengatur nama dan deskripsi Agent
        tvDetailName.text = agentName
        ivDetailPhoto.setImageResource(agentImageDetail)
        tvDetailRole.text = "Role \t\t\t\t: $agentRole"
        tvDetailOrigin.text = "Origin \t\t: $agentOrigin"
        tvDetailGender.text = "Gender \t: $agentGender"
        tvDetailBiography.text = agentBiography
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                shareAgentDetails() // Panggil metode yang akan menangani berbagi
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun shareAgentDetails() {
        val agentName = intent.getStringExtra("key_agent_name")
        val agentBiography = intent.getStringExtra("key_agent_biography")

        val shareText = "Check this out Agent $agentName\n\nBiography: $agentBiography"

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

}
