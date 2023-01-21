
package com.route.islamic37sat.home.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic37sat.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    lateinit var adapter: HadethRecyclerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
        adapter = HadethRecyclerAdapter(hadethList)
        viewBinding.hadethRecycler.adapter = adapter

    }

    val hadethList = mutableListOf<Hadeth>()

    fun readHadethFile() {
        val fileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }
        val allHadethList = fileContent.split("#");
//        for(String item:allHadethList){
//
//        }
        allHadethList.forEach { hadethContent ->
//            val indexOfFirstLine = hadethContent.indexOf('\n');
//            val title = hadethContent.substring(0,indexOfFirstLine)
//            val content = hadethContent.substring(indexOfFirstLine)
            val title = hadethContent.trim().substringBefore('\n')
            val content = hadethContent.trim().substringAfter('\n')
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }

    }
}