package com.example.tonalitysearch2

import android.content.Intent
import android.media.AudioManager
import android.media.ToneGenerator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tonalitysearch2.databinding.ActivityMetronomoBinding
import java.util.*
import kotlin.concurrent.thread
import kotlin.concurrent.timerTask

class Metronomo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bind4=ActivityMetronomoBinding.inflate(layoutInflater)
        setContentView(bind4.root)
        bind4.editbeat.setText("100")
        var BPM:Long=bind4.editbeat.text.toString().toLong()
        

        var estado:Boolean=false
        var milisegundos:Long=0
        val segundosporminuto:Long=60
        lateinit var metronomo: Timer
        val tono= ToneGenerator.TONE_PROP_BEEP2

        //este metodo crea el objeto Timer
        fun Crearsonido(){
            if(!estado){
                metronomo= Timer("metronomo",true)
                estado=true
            }
        }//con estos metodos controlamos el tempo
        fun arribatempo():Long{
           var BPM:Long=bind4.editbeat.text.toString().toLong()
           BPM++

            bind4.editbeat.setText(BPM.toString())
            return BPM
        }
        fun abajotempo(BPM:Long):Long{
            var BPM:Long=bind4.editbeat.text.toString().toLong()
            BPM--

            bind4.editbeat.setText(BPM.toString())
            return BPM


        }


        fun calculotempo(): Long {
            var BPM:Long=bind4.editbeat.text.toString().toLong()


                milisegundos = (1000 * (segundosporminuto /BPM.toDouble())).toLong()
                return milisegundos

        }//metodo de comienzo
        fun start(BPM:Long):Boolean {

                metronomo.schedule(
                        timerTask {
                            val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100)
                            toneGenerator.startTone(tono)
                            toneGenerator.release()

                                  },0L,
                        calculotempo()

                )
            return true

        }
        //parada del metronomo
        fun stop():Boolean{
            metronomo.cancel()

            bind4.play.isEnabled=true
            //Crearsonido()
            return true
        }



        bind4.mas.setOnClickListener {
            arribatempo()
        }
        bind4.menos.setOnClickListener {

                abajotempo(BPM)
        }
        bind4.play.setOnClickListener {
             //var BPM=bind4.editbeat.text.toString().toLong()
            Crearsonido()
            start(BPM)

            estado=true

            bind4.play.isEnabled=false

        }


        bind4.stop.setOnClickListener {
            stop()
            estado=false
            bind4.play.isEnabled=true
        }
        bind4.volver3.setOnClickListener {
            //sistema de seguridad para acbar el proceso al salir
                if(estado){
                    stop()
                    estado=false
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    val intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            //si no hacemos esto puede provocar fallo





        }
        bind4.reset2.setOnClickListener {
            if(estado){
                stop()
                estado=false
                bind4.editbeat.setText("100")

            }else{
                bind4.editbeat.setText("100")
            }
        }



    }
}