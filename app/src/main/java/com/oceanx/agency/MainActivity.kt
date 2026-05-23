package com.oceanx.agency

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.oceanx.agency.adapter.OrderAdapter
import com.oceanx.agency.databinding.ActivityMainBinding
import com.oceanx.agency.model.Order
import com.oceanx.agency.model.OrderStatus
import com.oceanx.agency.utils.DummyData

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: OrderAdapter
    private val allOrders = DummyData.getOrders()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupTabs()
        setupBanner()
        setupBottomNav()
        setupSearchFilterSort()
    }

    private fun setupRecyclerView() {
        adapter = OrderAdapter(allOrders)
        binding.rvOrders.layoutManager = LinearLayoutManager(this)
        binding.rvOrders.adapter = adapter
    }

    private fun setupTabs() {
        val tabs = listOf(
            binding.tabAll to null,
            binding.tabCompleted to OrderStatus.COMPLETED,
            binding.tabCancelled to OrderStatus.CANCELLED,
            binding.tabBookedAgain to null
        )

        tabs.forEach { (tab, status) ->
            tab.setOnClickListener {
                // Reset all tabs
                tabs.forEach { (t, _) -> resetTab(t) }
                // Select current tab
                selectTab(tab)

                // Filter orders
                val filtered = when (status) {
                    null -> if (tab == binding.tabAll) allOrders else emptyList()
                    else -> allOrders.filter { it.status == status }
                }
                adapter.updateList(filtered.ifEmpty { if (tab == binding.tabAll) allOrders else emptyList() })
            }
        }
    }

    private fun selectTab(tab: TextView) {
        tab.setBackgroundResource(R.drawable.bg_tab_selected)
        tab.setTextColor(getColor(R.color.black))
        tab.textSize = 13f
        // Bold
        tab.setTypeface(null, android.graphics.Typeface.BOLD)
    }

    private fun resetTab(tab: TextView) {
        tab.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        tab.setTextColor(getColor(R.color.text_gray))
        tab.setTypeface(null, android.graphics.Typeface.NORMAL)
    }

    private fun setupBanner() {
        binding.ivCloseBanner.setOnClickListener {
            binding.llInfoBanner.visibility = View.GONE
        }
    }

    private fun setupBottomNav() {
        binding.navHome.setOnClickListener {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
        }
        binding.navOrders.setOnClickListener {
            // Already on orders
        }
        binding.navPayments.setOnClickListener {
            Toast.makeText(this, "Payments", Toast.LENGTH_SHORT).show()
        }
        binding.navAccount.setOnClickListener {
            Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
        }
        // Help FAB
        binding.fabHelp.setOnClickListener {
            Toast.makeText(this, "Help & Support", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupSearchFilterSort() {
        binding.btnFilter.setOnClickListener {
            Toast.makeText(this, "Filter clicked", Toast.LENGTH_SHORT).show()
        }
        binding.btnSort.setOnClickListener {
            Toast.makeText(this, "Sort clicked", Toast.LENGTH_SHORT).show()
        }
    }
}