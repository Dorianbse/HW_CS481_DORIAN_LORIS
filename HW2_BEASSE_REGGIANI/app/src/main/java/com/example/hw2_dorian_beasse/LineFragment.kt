package com.example.hw2_dorian_beasse

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidplot.xy.*
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class LineFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_line, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myPlot = view.findViewById<XYPlot>(R.id.Lineplot)

        val domainLabels = arrayOf<Number>(1,2,3,4)

        val series1Number = arrayOf<Number>(4.3, 2.5, 3.5, 4.5);
        val series2Number = arrayOf<Number>(2.4, 4.4, 1.8, 2.8);
        val series3Number = arrayOf<Number>(2, 2, 3, 5);


        val series1 = SimpleXYSeries(
            Arrays.asList(* series1Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "A"
        )
        val series2: XYSeries = SimpleXYSeries(
            Arrays.asList(* series2Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "B"
        )
        val series3: XYSeries = SimpleXYSeries(
            Arrays.asList(* series3Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "C"
        )
        val series1Format = LineAndPointFormatter(Color.BLUE, Color.BLUE, null, null)
        val series2Format = LineAndPointFormatter(Color.rgb(255,170,0), Color.rgb(255,170,0), null, null)
        val series3Format = LineAndPointFormatter(Color.GREEN, Color.GREEN, null, null)
        myPlot.addSeries(series1, series1Format)
        myPlot.addSeries(series2, series2Format)
        myPlot.addSeries(series3, series3Format)

        myPlot.getGraph().getLineLabelStyle(XYGraphWidget.Edge. BOTTOM).format = object : Format() {
            override fun format(
                obj: Any?,
                toAppendTo: StringBuffer,
                pos: FieldPosition
            ): StringBuffer {
                val i = Math.round((obj as Number).toFloat())
                return toAppendTo.append(domainLabels[i])
            }

            override fun parseObject(source: String?, pos: ParsePosition): Any? {
                return null
            }}
        PanZoom.attach(myPlot)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}