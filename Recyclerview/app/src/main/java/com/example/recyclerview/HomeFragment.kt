package com.example.recyclerview

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentHomeBinding

class HomeFragment() : Fragment(R.layout.fragment_home), Parcelable {
    private var binding: FragmentHomeBinding? = null
    private lateinit var adapter : Adapter

    constructor(parcel: Parcel) : this() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentHomeBinding =FragmentHomeBinding.bind(view)
        binding = fragmentHomeBinding

        adapter = Adapter()
        adapter.submitList(mutableListOf<ArticleModel>().apply {
            add(ArticleModel("피카츄",1,"10000원","https://w7.pngwing.com/pngs/441/722/png-transparent-pikachu-thumbnail.png"))
            add(ArticleModel("라이츄",2,"15000원","https://static.wikia.nocookie.net/pokemon/images/9/92/%EC%A0%84%EC%A7%84%EC%9D%98_%EB%9D%BC%EC%9D%B4%EC%B8%84.png/revision/latest/scale-to-width-down/1200?cb=20220729043935&path-prefix=ko"))
            add(ArticleModel("피카츄",1,"10000원","https://w7.pngwing.com/pngs/441/722/png-transparent-pikachu-thumbnail.png"))
            add(ArticleModel("라이츄",2,"15000원","https://static.wikia.nocookie.net/pokemon/images/9/92/%EC%A0%84%EC%A7%84%EC%9D%98_%EB%9D%BC%EC%9D%B4%EC%B8%84.png/revision/latest/scale-to-width-down/1200?cb=20220729043935&path-prefix=ko"))
            add(ArticleModel("피츄",3,"22000원","https://i.namu.wiki/i/nOrOqNI0KKLacJSA8Dw_xttWqVR4theEDGtdyIUR2EBveCxx-7q5UkZYF63VWCArP91QgNVoCCPkyLCcUc79YA.webp"))
            add(ArticleModel("피카츄",1,"10000원","https://w7.pngwing.com/pngs/441/722/png-transparent-pikachu-thumbnail.png"))
            add(ArticleModel("라이츄",2,"15000원","https://static.wikia.nocookie.net/pokemon/images/9/92/%EC%A0%84%EC%A7%84%EC%9D%98_%EB%9D%BC%EC%9D%B4%EC%B8%84.png/revision/latest/scale-to-width-down/1200?cb=20220729043935&path-prefix=ko"))
            add(ArticleModel("피츄",3,"22000원","https://i.namu.wiki/i/nOrOqNI0KKLacJSA8Dw_xttWqVR4theEDGtdyIUR2EBveCxx-7q5UkZYF63VWCArP91QgNVoCCPkyLCcUc79YA.webp"))
            add(ArticleModel("피카츄",1,"10000원","https://w7.pngwing.com/pngs/441/722/png-transparent-pikachu-thumbnail.png"))
            add(ArticleModel("라이츄",2,"15000원","https://static.wikia.nocookie.net/pokemon/images/9/92/%EC%A0%84%EC%A7%84%EC%9D%98_%EB%9D%BC%EC%9D%B4%EC%B8%84.png/revision/latest/scale-to-width-down/1200?cb=20220729043935&path-prefix=ko"))
            add(ArticleModel("피츄",3,"22000원","https://i.namu.wiki/i/nOrOqNI0KKLacJSA8Dw_xttWqVR4theEDGtdyIUR2EBveCxx-7q5UkZYF63VWCArP91QgNVoCCPkyLCcUc79YA.webp"))
            add(ArticleModel("피츄",3,"22000원","https://i.namu.wiki/i/nOrOqNI0KKLacJSA8Dw_xttWqVR4theEDGtdyIUR2EBveCxx-7q5UkZYF63VWCArP91QgNVoCCPkyLCcUc79YA.webp"))
        })


        fragmentHomeBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.recyclerView.adapter=adapter
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HomeFragment> {
        override fun createFromParcel(parcel: Parcel): HomeFragment {
            return HomeFragment(parcel)
        }

        override fun newArray(size: Int): Array<HomeFragment?> {
            return arrayOfNulls(size)
        }
    }
}