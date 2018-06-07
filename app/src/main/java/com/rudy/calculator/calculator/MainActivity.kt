package com.rudy.calculator.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etnumber.isEnabled = false
        etnumber.isFocusable = false

    }
var decidot = 1
    fun NumberEvent(view:View)
    {
        try {

            if (newOp) {
                etnumber.setText("")
                decidot = 1
            }
            newOp = false
            val buSelect = view as Button
            var buClickValue:String = etnumber.text.toString()


            when (buSelect.id) {
                bu0.id -> {
                    buClickValue += "0"
                }
                bu1.id -> {
                    buClickValue += "1"
                }
                bu2.id -> {
                    buClickValue += "2"
                }
                bu3.id -> {
                    buClickValue += "3"
                }
                bu4.id -> {
                    buClickValue += "4"
                }
                bu5.id -> {
                    buClickValue += "5"
                }
                bu6.id -> {
                    buClickValue += "6"
                }
                bu7.id -> {
                    buClickValue += "7"
                }
                bu8.id -> {
                    buClickValue += "8"
                }
                bu9.id -> {
                    buClickValue += "9"
                }
                budot.id -> {
                    if (decidot == 1) {
                        if (buClickValue == "")
                        {
                            buClickValue = "0."
                        }
                        else {
                            buClickValue += "."
                        }
                        decidot = 0
                    }
                }

            }
            etnumber.setText(buClickValue)
            finalNumber = buClickValue.toDouble()
        }catch (ex:Exception)
        {
            Toast.makeText(this,ex.message,Toast.LENGTH_LONG).show()
        }
    }


    fun signChange(view:View)
    {
        val numsign:Double = etnumber.text.toString().toDouble() * -1
        etnumber.setText(numsign.toString())
        finalNumber = numsign
    }

    var op = "none"
    var oldNumber = "0"
    var newOp = true

    fun OpEvent(view:View)
    {
        val buSelect = view as Button
        when(buSelect.id) {
            bumul.id -> {
                op = "*"
            }
            budiv.id -> {
                op = "/"
            }
            buplus.id -> {
                op = "+"
            }
            buminus.id -> {
                op = "-"
            }
        }
        oldNumber = etnumber.text.toString()
        newOp = true
        decidot = 1

    }

    var finalNumber: Double? = 0.0

    fun buEqual(view:View)
    {
        try {
            if (etnumber.text.toString() == ".")
            {
                etnumber.setText("0.0")
            }
            val newNumber = etnumber.text.toString()


            when (op) {
                "*" -> {
                    finalNumber = oldNumber.toDouble() * newNumber.toDouble()
                }
                "/" -> {
                    finalNumber = oldNumber.toDouble() / newNumber.toDouble()
                }
                "+" -> {
                    finalNumber = oldNumber.toDouble() + newNumber.toDouble()
                }
                "-" -> {
                    finalNumber = oldNumber.toDouble() - newNumber.toDouble()
                }
                else -> {
                    finalNumber = finalNumber
                }
            }
            op = "none"

            etnumber.setText(finalNumber.toString())
            decidot = 1
            newOp = true

        }catch (ex:Exception)
        {
            Toast.makeText(this,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    fun bupercent(view:View)
    {
        val number:Double = etnumber.text.toString().toDouble() / 100
        finalNumber = number
        etnumber.setText(number.toString())
        decidot = 1
        newOp = true
    }

    fun buclear(view:View)
    {
        etnumber.setText("0")
        decidot = 1
        newOp = true
    }

}
