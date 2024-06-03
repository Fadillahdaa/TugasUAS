package com.kelmobile.tugasuas

import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TiketBookingactivity: AppCompatActivity() {

    private lateinit var seatsLayout: GridLayout
    private lateinit var ticketInfo: TextView
    private lateinit var totalAmount: TextView
    private val selectedSeats = mutableListOf<Int>()
    private val seatCount = 50 // Total number of seats

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seatsLayout = findViewById(R.id.seats_layout)
        ticketInfo = findViewById(R.id.ticket_info)
        totalAmount = findViewById(R.id.total_amount)
        val backButton: ImageButton = findViewById(R.id.back_button)
        val btnPaymentOptions: Button = findViewById(R.id.btn_payment_options)

        backButton.setOnClickListener {
            // Handle back button click
            Toast.makeText(this, "Back button clicked", Toast.LENGTH_SHORT).show()
        }

        btnPaymentOptions.setOnClickListener {
            // Handle payment options button click
            Toast.makeText(this, "Payment options clicked", Toast.LENGTH_SHORT).show()
        }

        addSeatsDynamically()
        updateTicketDetails()
    }

    private fun addSeatsDynamically() {
        for (i in 1..seatCount) {
            val seatButton = Button(this).apply {
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(4, 4, 4, 4)
                }
                text = i.toString()
                setBackgroundResource(R.drawable.seat_background) // Use drawable for seat background
                setOnClickListener {
                    onSeatButtonClick(i, this)
                }
            }
            seatsLayout.addView(seatButton)
        }
    }

    private fun onSeatButtonClick(seatNumber: Int, seatButton: Button) {
        if (selectedSeats.contains(seatNumber)) {
            // Deselect seat
            selectedSeats.remove(seatNumber)
            seatButton.setBackgroundResource(R.drawable.seat_background) // Change to unselected seat background
            Toast.makeText(this, "Seat $seatNumber deselected", Toast.LENGTH_SHORT).show()
        } else {
            // Select seat
            selectedSeats.add(seatNumber)
            seatButton.setBackgroundResource(R.drawable.selected_seat_background) // Change to selected seat background
            Toast.makeText(this, "Seat $seatNumber selected", Toast.LENGTH_SHORT).show()
        }
        updateTicketDetails()
    }

    private fun updateTicketDetails() {
        val ticketCount = selectedSeats.size
        val ticketPrice = ticketCount * 20 // Assuming each
