package com.example.exoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exoplayer.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var videoAdapter: VideoAdapter
    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initMotionLayout()
        initVideoRecyclerView()

        binding.playerRecyclerView
    }

    private fun initVideoRecyclerView() {
        videoAdapter = VideoAdapter(context = this) { videoItem ->

            binding.motionLayout.transitionToEnd()
            play(videoItem)
        }


        binding.videoListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = videoAdapter
        }

        val videoList = readData("videos.json", VideoList::class.java) ?: VideoList(emptyList())
        videoAdapter.submitList(videoList.videos)
    }

    private fun initMotionLayout() {
        binding.motionLayout.targetView = binding.videoPlayerContainer
        binding.motionLayout.jumpToState(R.id.collapse)
    }

    private fun play(videoItem: VideoEntity) {
        player?.setMediaItem(MediaItem.fromUri(Uri.parse((videoItem.videoUrl))))
        player?.prepare()
        player?.play()
    }

    private fun initExoPlayer() {
        player = ExoPlayer.Builder(this).build()
            .also { exoPlayer ->
                binding.playerView.player = exoPlayer
            }

    }

    override fun onStart() {
        super.onStart()
        if (player == null) {
            initExoPlayer()
        }

    }

    override fun onResume() {
        super.onResume()
        if (player == null) {
            initExoPlayer()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }

    override fun onStop() {
        super.onStop()
        player?.pause()
    }
}