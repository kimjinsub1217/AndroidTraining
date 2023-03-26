package com.example.chattingapp.chatlist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chattingapp.Key.Companion.DB_CHAT_ROOMS
import com.example.chattingapp.R
import com.example.chattingapp.chatdetail.ChatActivity
import com.example.chattingapp.databinding.FragmentChatlistBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatListFragment : Fragment(R.layout.fragment_chatlist) {

    private lateinit var binding: FragmentChatlistBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatlistBinding.bind(view)



        val chatListAdapter = ChatListAdapter{chatRoomItem ->
            chatRoomItem.otherUserId
            chatRoomItem.chatRoomId

            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra(ChatActivity.EXTRA_OTHER_USER_ID, chatRoomItem.otherUserId)
            intent.putExtra(ChatActivity.EXTRA_CHAT_ROOM_ID,chatRoomItem.chatRoomId)


            startActivity(intent)
        }
        binding.chatListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatListAdapter
        }
//        chatListAdapter.submitList(
//            mutableListOf<ChatRoomItem?>().apply {
//                add(ChatRoomItem("11","22","33"))
//            }
//        )
        val currentUserId = Firebase.auth.currentUser?.uid ?: ""
        val chatRoomsDB = Firebase.database.reference.child(DB_CHAT_ROOMS).child(currentUserId)

        chatRoomsDB.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val chatRoomsList = snapshot.children.map {
                    it.getValue(ChatRoomItem::class.java)
                }
                chatListAdapter.submitList(chatRoomsList)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }


}