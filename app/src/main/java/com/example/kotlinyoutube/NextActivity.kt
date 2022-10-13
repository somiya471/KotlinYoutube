package com.example.kotlinyoutube

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class NextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val intent = intent
        val name = intent.getStringExtra("name")
        val desc = intent.getStringExtra("desc")

        val desc_set = findViewById<TextView>(R.id.desctext)
        val video = findViewById<VideoView>(R.id.videoView)
        desc_set.text = desc

        val apath = "android.resource://"+getPackageName()+"/raw/"+name;
        val videouri = Uri.parse(apath);

        video.setVideoURI(videouri)
        video.start()

        val mediaController = MediaController(this)
        video.setMediaController(mediaController)
        mediaController.setAnchorView(video)

    }
}