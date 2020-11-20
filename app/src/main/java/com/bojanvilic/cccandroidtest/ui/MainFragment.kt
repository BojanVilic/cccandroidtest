package com.bojanvilic.cccandroidtest.ui

import android.content.res.AssetFileDescriptor
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bojanvilic.cccandroidtest.R
import com.bojanvilic.cccandroidtest.databinding.MainFragmentBinding
import com.bojanvilic.cccandroidtest.models.Estimate
import com.bojanvilic.cccandroidtest.models.Person
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var viewBinding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application).create(MainViewModel::class.java)

        viewBinding = MainFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        insertData();

        subscribeObservers();
    }

    private fun subscribeObservers() {
        viewModel.getEstimateById().observe(viewLifecycleOwner, Observer {
            estimate -> viewBinding.estimate = estimate
        })

        viewModel.getPersonById().observe(viewLifecycleOwner, Observer {
            person -> viewBinding.person = person
            viewBinding.fullName = person.firstName + " " + person.lastName
        })
    }

    private fun insertData() {
        val jsonObject = JSONObject(readJson())

        val gson = GsonBuilder().create()
        val estimate = gson.fromJson(jsonObject.getJSONObject("estimate").toString(), Estimate::class.java)
        val person = gson.fromJson(jsonObject.getJSONObject("person").toString(), Person::class.java)

        viewModel.insertEstimate(estimate)
        viewModel.insertPerson(person)
    }

    private fun readJson(): String {
        val json: String
        val inputStream: InputStream = activity!!.application.assets.open("json_data")
        json = inputStream.bufferedReader().use { it.readText() }
        return json
    }

}