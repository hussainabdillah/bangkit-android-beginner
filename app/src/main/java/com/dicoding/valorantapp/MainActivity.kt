package com.dicoding.valorantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAgents: RecyclerView
    private val list = ArrayList<Agent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAgents = findViewById(R.id.rv_agents)
        rvAgents.setHasFixedSize(true)

        list.addAll(getListAgents())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvAgents.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvAgents.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_profile -> {
                // Implementasi untuk opsi "Profile" di sini
                startActivity(Intent(this, ProfileActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAgents(): ArrayList<Agent> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPhotoDetail = resources.obtainTypedArray(R.array.data_photo_detail)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataGender = resources.getStringArray(R.array.data_gender)
        val dataOrigin = resources.getStringArray(R.array.data_origin)
        val dataBiography = resources.getStringArray(R.array.data_biography)
        val listAgent = ArrayList<Agent>()
        for (i in dataName.indices) {
            val agent = Agent(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataPhotoDetail.getResourceId(i, -1), dataRole[i], dataOrigin[i], dataGender[i], dataBiography[i]    )
            listAgent.add(agent)
        }
        return listAgent
    }

    private fun showRecyclerList() {
        rvAgents.layoutManager = LinearLayoutManager(this)
        val listAgentAdapter = ListAgentAdapter(list)
        rvAgents.adapter = listAgentAdapter

        listAgentAdapter.setOnItemClickCallback(object : ListAgentAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Agent) {
                showSelectedAgent(data)
            }
        })
    }

    private fun showSelectedAgent(hero: Agent) {
        Toast.makeText(this, "Agent " + hero.name, Toast.LENGTH_SHORT).show()
    }
}