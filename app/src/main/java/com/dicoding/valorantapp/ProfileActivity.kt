package com.dicoding.valorantapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var ivProfile: ImageView
    private lateinit var tvAdditionalInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Inisialisasi tampilan dengan findViewById
        tvName = findViewById(R.id.tvName)
        ivProfile = findViewById(R.id.ivProfile)
        tvAdditionalInfo = findViewById(R.id.tvAdditionalInfo)

        // Mengambil data profil dari sumber data atau sesuai kebutuhan aplikasi Anda
        val userName = "Hussain Abdillah Tugas Kelarno"
        val userImage = R.drawable.profile_image
        val email = "hussainkelarno@gmail.com"

        // Menampilkan data profil di tampilan
        tvName.text = userName
        ivProfile.setImageResource(userImage)
        tvAdditionalInfo.text = email
    }
}
